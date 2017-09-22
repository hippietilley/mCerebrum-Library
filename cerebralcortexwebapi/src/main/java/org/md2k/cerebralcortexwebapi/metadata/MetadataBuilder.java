package org.md2k.cerebralcortexwebapi.metadata;

import android.provider.ContactsContract;

import org.md2k.cerebralcortexwebapi.models.stream.Algorithm;
import org.md2k.cerebralcortexwebapi.models.stream.Annotation;
import org.md2k.cerebralcortexwebapi.models.stream.DataDescriptor;
import org.md2k.cerebralcortexwebapi.models.stream.DataPoints;
import org.md2k.cerebralcortexwebapi.models.stream.DataStream;
import org.md2k.cerebralcortexwebapi.models.stream.ExecutionContext;
import org.md2k.cerebralcortexwebapi.models.stream.InputParameters;
import org.md2k.cerebralcortexwebapi.models.stream.ProcessingModule;
import org.md2k.cerebralcortexwebapi.models.stream.Properties;
import org.md2k.cerebralcortexwebapi.models.stream.Reference;
import org.md2k.cerebralcortexwebapi.models.stream.InputStream;
import org.md2k.cerebralcortexwebapi.models.stream.OutputStream;

import java.util.ArrayList;
import java.util.List;


public class MetadataBuilder {

    public DataStream buildDataStreamMetadata(String type, String identifier, String owner, String name, String rawOrZip){
        //TODO: use identifier to query sqlite database and fetch relevant metadata

        //Algorithm
        String algoMethod = "";
        String algoDescription = "";
        String algoAuthorName = "Ali";
        List<String> authors = new ArrayList<String>();
        authors.add(algoAuthorName);
        String algoVersion = "1.0";

        //Reference meta
        String referenceUrl = "mdk2.org";

        //Annotations meta
        String annotationName = "";
        String annotationIdentifier = "";

        //DataDescriptor meta
        String dataType = "";
        String dataUnit = "";

        //InputParameters meta
        Integer windowSize=60;
        Integer windowOffset=300;
        Double lowLevelThreshold=1.1;
        Double highLevelThreshold=1.4;

        //InputStream meta
        String inputStreamName = "";
        String inputStreamIdentifier = "";

        //outputStream meta
        String outputStreamName = "";
        String outputStreamIdentifier = "";

        //ProcessingModule meta
        String processingModuleName="";
        String processingModuleDescription="";




        InputStream inputStream = new InputStream(inputStreamName, inputStreamIdentifier);

        OutputStream outputStream = new OutputStream(outputStreamName, outputStreamIdentifier);
        InputParameters inputParameters = new InputParameters(windowSize, windowOffset, lowLevelThreshold, highLevelThreshold);
        DataDescriptor dataDescriptor = new DataDescriptor(dataType, dataUnit);
        Annotation annotation = new Annotation(annotationName, annotationIdentifier);
        Reference reference = new Reference(referenceUrl);
        Algorithm algorithm = new Algorithm(algoMethod, algoDescription, authors, algoVersion, reference);

        List<InputStream> inputStreams = new ArrayList<InputStream>();
        inputStreams.add(inputStream);
        List<OutputStream> outputStreams = new ArrayList<OutputStream>();
        outputStreams.add(outputStream);
        List<Algorithm> algorithms = new ArrayList<Algorithm>();
        algorithms.add(algorithm);
        List<DataDescriptor> dataDescriptors = new ArrayList<DataDescriptor>();
        dataDescriptors.add(dataDescriptor);
        List<Annotation> annotations = new ArrayList<Annotation>();
        annotations.add(annotation);

        ProcessingModule processingModule = new ProcessingModule(processingModuleName, processingModuleDescription, inputParameters, inputStreams, outputStreams, algorithms);
        ExecutionContext executionContext = new ExecutionContext(processingModule);

        if(rawOrZip=="zip") {
            DataStream dataStream = new DataStream(type, identifier, owner, name, dataDescriptors, executionContext, annotations);
            return dataStream;
        }else{
            DataPoints dataPoints = new DataPoints("12345", "156789", "0101");
            List<DataPoints> dataPointsList = new ArrayList<DataPoints>();
            dataPointsList.add(dataPoints);
            DataStream dataStream = new DataStream(type, identifier, owner, name, dataDescriptors, executionContext, annotations, dataPointsList);
            return dataStream;
        }

    }

}
