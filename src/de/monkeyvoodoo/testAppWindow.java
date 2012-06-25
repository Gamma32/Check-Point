package de.monkeyvoodoo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;


public class testAppWindow
{
    private Browser browser;

    protected Shell shell;

    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            testAppWindow window = new testAppWindow();
            window.open();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Open the window.
     */
    public void open()
    {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
            {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the window.
     */
    protected void createContents()
    {
        shell = new Shell();
        shell.setSize(450, 300);
        shell.setText("SWT Application");
        
        try {
            browser = new Browser(shell, SWT.NONE);
        } catch (Exception e) {
            /* The Browser widget throws an SWTError if it fails to
             * instantiate properly. Application code should catch
             * this SWTError and disable any feature requiring the
             * Browser widget.
             * Platform requirements for the SWT Browser widget are available
             * from the SWT FAQ website. 
             */
        }
        if (browser != null) {
            /* The Browser widget can be used */
            browser.setUrl("http://www.eclipse.org");
        }
        
        
        browser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDoubleClick(MouseEvent e) {
            }
        });
        browser.setBounds(10, 10, 414, 242);

    }
}
