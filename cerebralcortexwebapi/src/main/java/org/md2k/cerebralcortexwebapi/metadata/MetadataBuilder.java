package org.md2k.cerebralcortexwebapi.metadata;

import org.md2k.cerebralcortexwebapi.models.stream.Algorithm;
import org.md2k.cerebralcortexwebapi.models.stream.Annotation;
import org.md2k.cerebralcortexwebapi.models.stream.DataDescriptor;
import org.md2k.cerebralcortexwebapi.models.stream.DataStream;
import org.md2k.cerebralcortexwebapi.models.stream.ExecutionContext;
import org.md2k.cerebralcortexwebapi.models.stream.ProcessingModule;
import org.md2k.cerebralcortexwebapi.models.stream.Properties;
import org.md2k.cerebralcortexwebapi.models.stream.Reference;
import org.md2k.cerebralcortexwebapi.models.stream.InputStream;
import org.md2k.cerebralcortexwebapi.models.stream.OutputStream;


public class MetadataBuilder {

    public static DataStream buildDataStream(){
        DataStream dataStream = new DataStream();
        return dataStream;
    }

    private Algorithm getAlgorithm(){
        Algorithm algorithm = new Algorithm();
        return algorithm;
    }

    private Annotation getAnnotation(){
        Annotation annotation = new Annotation();
        return annotation;
    }

    private DataDescriptor getDataDescriptor(){
        DataDescriptor dataDescriptor = new DataDescriptor();
        return dataDescriptor;
    }

    private ExecutionContext getExecutionContext(){
        ExecutionContext executionContext = new ExecutionContext();
        return executionContext;
    }

    private InputStream getInputStream(){
        InputStream inputStream = new InputStream();
        return inputStream;
    }

    private OutputStream getOutputStream(){
        OutputStream outputStream = new OutputStream();
        return outputStream;
    }

    private ProcessingModule getProcessingModule(){
        ProcessingModule processingModule = new ProcessingModule();
        return processingModule;
    }

    private Properties getProperties(){
        Properties properties = new Properties();
        return properties;
    }

    private Reference getReference(){
        Reference reference = new Reference();
        return reference;
    }

}
