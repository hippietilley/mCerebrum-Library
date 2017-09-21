package org.md2k.cerebralcortexwebapi.models.stream;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExecutionContext {

    @SerializedName("processing_module")
    @Expose
    private ProcessingModule processingModule;

    /**
     * No args constructor for use in serialization
     *
     */
    public ExecutionContext() {
    }

    /**
     *
     * @param processingModule
     */
    public ExecutionContext(ProcessingModule processingModule) {
        super();
        this.processingModule = processingModule;
    }

    public ProcessingModule getProcessingModule() {
        return processingModule;
    }

    public void setProcessingModule(ProcessingModule processingModule) {
        this.processingModule = processingModule;
    }

}