package app.beans;

public class LazyBean {
    public static boolean isBeanInstantiated = false;

    public void postConstruct() {
        isBeanInstantiated = true;
    }
}
