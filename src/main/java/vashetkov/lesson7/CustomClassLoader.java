package vashetkov.lesson7;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

public class CustomClassLoader extends ClassLoader{
    public static final String REPO_LOCATION = "C:/myClasses/";

    CustomClassLoader() {
    }

    CustomClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(final String name)   throws ClassNotFoundException {
        AccessControlContext accessControlContext = AccessController.getContext();

        try {
            return (Class) AccessController.doPrivileged(new PrivilegedExceptionAction() {
                        public Object run() throws ClassNotFoundException {
                            FileInputStream fi = null;
                            try {
                                String path = name.replace('.', '/');
                                fi = new FileInputStream(REPO_LOCATION + path+ ".class");
                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                byte[] buffer = new byte[8192]; // a big chunk
                                int read;
                                while ((read = fi.read(buffer)) > 0)
                                    baos.write(buffer, 0, read);
                                byte[] classBytes= baos.toByteArray();

                                return defineClass(name, classBytes, 0,
                                        classBytes.length);
                            } catch (Exception e) {
                                throw new ClassNotFoundException(name);
                            }
                        }
                    }, accessControlContext);
        } catch (PrivilegedActionException pae) {
            return super.findClass(name);
        }
    }
}
