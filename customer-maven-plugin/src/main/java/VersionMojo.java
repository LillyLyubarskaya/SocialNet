import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

/**
 * Created by Lilly_94 on 08.11.2015.
 */
@Mojo( name = "getversion")
public class VersionMojo extends AbstractMojo
{
    public void execute() throws MojoExecutionException
    {
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        String version="v1";
        try {
            Repository repository = builder.readEnvironment().findGitDir().build();// scan environment GIT_* variables
            Map<String,Ref> tags=repository.getTags();
            Iterator it = tags.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                version=pair.getKey().toString();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        getLog().info("Getting version. - "+version );

        //save version to Version.class
        String root=new File("").getAbsolutePath();
        File dir=new File(root+"/target/generated-sources/");
        if(!dir.exists())
            dir.mkdirs();
        File file=new File("generated-sources/target/Version.java");
        getLog().info("Generating version class.");
        try {
            OutputStream out=new FileOutputStream(file);
            out.write("package com.kpi.compsys.controller; public class Version {".getBytes());
            out.write("public static final String PROGRAM_VERSION=\"".getBytes());
            out.write((version+"\";").getBytes());
            out.write("}".getBytes());
            out.flush();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        getLog().info("Done.");
    }
}