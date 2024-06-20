package org.example;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class Processor {
    Map<String, String> map = new HashMap<>();
    InputClass inputClass = new InputClass();

    public Map<String, String> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "map=" + map +
                '}';
    }

    public Map<String, String> run(String path) {
        Collection<Tag> tags = new ArrayList<>();

        InputStream is = null;
        try {
//            for (String path : list) {
            File file = new File(path);
            is = new FileInputStream(file);
            // Базовый объект операционный объект
            try {
                Metadata metadata = ImageMetadataReader.readMetadata(is);
                // Получить все различные типы каталогов, такие как ExifSubIFDDirectory, ExifInteropDirectory, ExifThumbnailDirectory и т. Д., Эти классы ExifDirectoryBase расширяет подклассы каталога
                // Обходим каждый каталог отдельно, и соответствующую информацию можно прочитать в соответствии с тегами каталога
                Iterable<Directory> iterable = metadata.getDirectories();
                for (Iterator<Directory> iter = iterable.iterator(); iter.hasNext(); ) {
                    Directory dr = iter.next();
                    tags = dr.getTags();

                    for (Tag tag : tags) {
                        map.put(tag.getTagName().toString(), tag.getDescription().toString());
//                        System.out.println(tag.getTagName() + ", " + tag.getDescription());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}