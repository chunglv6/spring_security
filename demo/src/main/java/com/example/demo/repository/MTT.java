package com.example.demo.repository;


import com.fasterxml.uuid.Generators;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * A class that represents an immutable Master-Trace-Tag({@code MTT}).
 * The {@code MTT}'s uniqueness is provided by its properties: tag
 * and initiatorSystem.
 *
 * <p> The class {@code MTT } includes methods to initialize, generate,
 * compare {@code MTT) objects and also offers the possibility to
 * extract {@code Date} information from an {@code MTT}'s {@code tag}
 * property.
 *
 * <p> The {@code tag} property is responsible for storing a String value
 * which contains a time-based universally unique identifier.
 * It represents a 128-bit value.
 *
 * <p> The {@code initiatorSystem} property stores the creator/initiator
 * of the {@code MTT}.
 */
public final class MTT implements Serializable {

    /**
     * Explicit serialVersionUID for interoperability.
     */
    private static final long serialVersionUID = 4625825462105647451L;

    /**
     * The number of days between 15.10.1582 - 01.01.1970 represented
     * in milliseconds.
     * This constant value is used to correctly extract {@code Date}
     * information from the {@code MTT}'s universally unique identifier
     * stored in {@code tag}.
     */
    private static final long NUM_100NS_INTERVALS_SINCE_UUID_EPOCH = 0x01b21dd213814000L;

    /**
     * This property is used to store a time-based universally unique identifier.
     */
    private String tag;

    /**
     * This property is used to store the creator/initiator of this {@code MTT}.
     */
    private String initiatorSystem;

    /**
     * Empty constructor to support json deserialization.
     */
    private MTT() {
        // avoid instantiation
    }

    /**
     * Constructs a new {@code MTT} using the arguments.
     *
     * @param tag
     * 		The universally unique identifier of the {@code MTT},
     * 		represented as a {@code String} value.
     * @param initiatorSystem
     * 		The creator/initiator of the {@code MTT}.
     */
    public MTT(String tag, String initiatorSystem) {
        this.tag = tag;
        this.initiatorSystem = initiatorSystem;
    }

    /**
     * Generates a new {@code MTT} instance, using the name of
     * the initiator system as argument.
     *
     * @param initiatorSystem
     * 		The creator/initiator of the {@code MTT}.
     * @return a newly created {@code MTT} object with
     * an {@code initiatorSystem} and a random universally unique
     * identifier stored in {@code tag}.
     */
    public static MTT generateMTT(String initiatorSystem) {
        return new MTT(generateTag(), initiatorSystem);
    }

    /**
     * Generates a time-based universally unique identifier and
     * transforms it to a {@code String} object.
     *
     * @return a randomly generated universally unique identifier,
     * represented as a {@code String} value.
     */
    private static String generateTag() {
        return Generators.timeBasedGenerator().generate().toString();
    }

    /**
     * Extracts the {@code Date} from a time-based universally unique identifier.
     *
     * @param tag
     * 		The time-based unique identifier, represented
     * 		as a {@code String}.
     * @return a {@code Date} object created using the {@code tag}.
     */
    public static Date extractCreateDate(String tag) {
        UUID uuid = UUID.fromString(tag);
        long date = getTimeFromUUID(uuid);
        return new Date(date);
    }

    /**
     * Retrieves the corresponding time in milliseconds, extracted from the
     * timestamp of the {@code UUID}.
     *
     * @param uuid
     * 		A time-based universally unique identifier.
     * @return The extracted time as a {@code long} value,
     * represented in milliseconds.
     */
    private static long getTimeFromUUID(UUID uuid) {
        return (uuid.timestamp() - NUM_100NS_INTERVALS_SINCE_UUID_EPOCH) / 10000;
    }

    /**
     * Compares this {@code MTT} to a specified object.
     * The result is {@code true} only if the specified object is not
     * {@code null}, is an {@code MTT} object and stores the same values
     * in {@code tag} and {@code initiatorSystem} as this {@code MTT}.
     *
     * @param obj
     * 		The object to be compared.
     * @return {@code true} if the objects are the same; {@code false}
     * otherwise.
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        MTT mtt = (MTT) obj;
        return Objects.equals(tag, mtt.tag) && Objects.equals(initiatorSystem, mtt.initiatorSystem);
    }

    /**
     * Generates a hash code for this {@code MTT}.
     *
     * @return A hash code value for this {@code MTT}.
     */
    public int hashCode() {
        return Objects.hash(tag, initiatorSystem);
    }

    /**
     * Getter method for the {@code tag} property of this {@code MTT}.
     *
     * @return the {@code tag} property of this {@code MTT}.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Getter method for the {@code initiatorSystem} property
     * of this {@code MTT}.
     *
     * @return the {@code initiatorSystem} property of this {@code MTT}.
     */
    public String getInitiatorSystem() {
        return initiatorSystem;
    }
}
