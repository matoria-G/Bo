The samples illustrate the use of XDoclet via embedded @tag declarations in 
the source code.  The build can be run using Ant and the included build.xml 
file (use Jakarta Ant 1.5 or higher) or run using Maven (use Maven 1.0 or 
higher).

Running build.xml using Ant runs ejbdoclet and webdoclet so the deployment
descriptors and EJB-related classes and interfaces are generated, WAR, EJB-JAR
and EAR files created.

The build.xml shows a typical build process with XDoclet tasks in it. You can
use it as a template for build.xml file of your own project.

Instructions for end users:

- Now run ant, you should see the build process output.

Note that you can run "ant ejbdoclet" to run only the <ejbdoclet/> task which
does the EJB stuff or "ant webdoclet" to run only the <webdoclet/> task which
does the web stuff.

What you get:
 - Generated source files went to target/gen-src directory.
 - Generated deployment descriptors went to the corresponding directory under
   the target/meta-inf or target/web-inf directories.

Note:
By default <ejbdoclet/> will generate EJB 2.0 compatible output. If you are
using a 1.1 compatible application server you may want to tell <ejbdoclet/>
to generate 1.1 compatible output. To do this edit build.xml and set
ejbspec="1.1" for the <ejbdoclet/> task.

Note: 
The Maven version doesn't do everything the Ant version does.  For example, the
ejbdoclet only generates the ejb-jar.xml deployment descriptor, it doesn't generate
any of the Java code.  Source modification specified in project.xml ignores the
noncompiling EJB code.

Have Fun!
The XDoclet Team.