package BACKEND.utils;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.NoSuchFileException;

public class ResourceLoader
{
    private String filePath;

    public ResourceLoader(String filePath)
    {
        this.filePath = filePath;

        if(filePath.startsWith("/"))
        {
            throw new IllegalArgumentException("Relative paths may not have a leading slash!");
        }
    }

    public InputStream getResource() throws NoSuchFileException
    {
        ClassLoader classLoader = this.getClass().getClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream(filePath);

        if(inputStream == null)
        {
            throw new NoSuchFileException("Resource file not found. Note that the current directory is the source folder!");
        }

        return inputStream;
    }
    
    public  URL getResourcePath() throws NoSuchFileException{
    	ClassLoader classLoader = this.getClass().getClassLoader();

        URL path = classLoader.getResource(filePath);

        if(path == null)
        {
            throw new NoSuchFileException("Resource file not found. Note that the current directory is the source folder!");
        }

        return path;
    }
}
