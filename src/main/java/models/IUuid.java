package models;

import java.util.UUID;

/**
 * Any class that implements this interface should use UUID.randomUUID().toString() as their id.<br>
 * Intended usage example:<br>
 * Constructor: <br>
 * <code>public SomeObject(){
 *  setId(UUID.randomUUID())<br>
 * }</code><br>
 * Example setId: <br><code>public void setId(UUID uuid){<br>
 * this.id = uuid.toString()<br>
 * }</code>
 */
public interface IUuid {
    String getId();
    void setId(UUID uuid);
}
