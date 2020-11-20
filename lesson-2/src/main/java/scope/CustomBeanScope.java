package scope;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.*;

import java.util.*;

public class CustomBeanScope implements Scope {

    /*
    * Store and managing scoped objects in a thread-safe way.
    * */
    private Map<String, Object> scopedObjects = Collections.synchronizedMap(new HashMap<>());
    private Map<String, Runnable> destructionCallbacks = Collections.synchronizedMap(new HashMap<>());

    /*
    * It removes the named object from the scope and
    * also removes its registered destruction callback,
    * returning the removed object.
    * */
    @Override
    public Object remove(String name) {
        destructionCallbacks.remove(name);
        return scopedObjects.remove(name);
    }

    /*
    * To retrieve an object by name from our scope.
    * If the named object does not exist in the scope, this method must create and return a new object.
    * */
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if(!scopedObjects.containsKey(name)) {
            scopedObjects.put(name, objectFactory.getObject());
        }
        return scopedObjects.get(name);
    }

    /*
    * This method provides a callback that is to be executed when
    * the named object is destroyed or if the scope itself is destroyed by the application.
    * */
    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        destructionCallbacks.put(name, callback);
    }

    /*
     * If your scope supports multiple contextual objects,
     * you would associate each with a key value,
     * and you would return the object corresponding to the provided key parameter.
     * Otherwise, the convention is to return null
     * */
    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    /*
    * If your scope supports the concept of a conversation ID,
    * you would return it here. Otherwise, the convention is to return null
    * */
    @Override
    public String getConversationId() {
        return "tenant";
    }
}
