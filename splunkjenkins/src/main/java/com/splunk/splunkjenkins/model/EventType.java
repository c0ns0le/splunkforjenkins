package com.splunk.splunkjenkins.model;

public enum EventType {
    BUILD_REPORT(false),
    BUILD_EVENT(false),
    QUEUE_INFO(false),
    JENKINS_CONFIG(false),
    CONSOLE_LOG(true),
    FILE(true),
    SLAVE_INFO(false),
    GENERIC_TEXT(false) //generic text is the default type if not specified
    ;

    /**
     * whether the data need to be split by line breaker before send
     */
    private boolean needSplit;

    EventType(boolean needSplit) {
        this.needSplit = needSplit;
    }

    /**
     * need spit the content line by line if raw event not supported
     *
     * @return <code>true</code> if need spit the contents line by line if raw event not supported;
     * <code>false</code> otherwise.
     */
    public boolean needSplit() {
        return needSplit;
    }

    /**
     * @param suffix
     * @return return name.suffix
     */
    public String getKey(String suffix) {
        return this.name().toLowerCase() + "." + suffix;
    }
}
