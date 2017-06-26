import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Kaihan
 */
public class Main {

    static Scanner in = new Scanner(System.in);

    public static void toTft() throws IOException {
        //-------------------- Handling "/etc/modules" -------------------------
        File file = new File("/etc/modules");
        FileWriter fooWriter = new FileWriter(file, false); // true to append                                              // false to overwrite.
        fooWriter.write("# /etc/modules: kernel modules to load at boot time.\n"
                + "#\n"
                + "# This file contains the names of kernel modules that should be loaded\n"
                + "# at boot time, one per line. Lines beginning with \"#\" are ignored.\n"
                + "# Parameters can be specified after the module name.\n"
                + "\n"
                + "snd-bcm2835"
                + "\nfbtft_device name=flexpfb rotate=180 fps=60 gpios=dc:18,reset:7,wr:17,cs:4,db00:22,db01:23,db02:24,db03:10,db04:25,db05:9,db06:11,db07:8\n"
                + "flexfb width=480 height=320 buswidth=8 init=-1,0xb0,0x0,-1,0x11,-2,120,-1,0x3A,0x55,-1,0xC2,0x33,-1,0xC5,0x00,0x1E,0x80,-1,0x36,0x28,-1,0xB1,0xB0,-1,0xE0,0x00,0x04,0x0E,0x08,0x17,0x0A,0x40,0x79,0x4D,0x07,0x0E,0x0A,0x1A,0x1D,0x0F,-1,0xE1,0x00,0x1B,0x1F,0x02,0x10,0x05,0x32,0x34,0x43,0x02,0x0A,0x09,0x33,0x37,0x0F,-1,0x11,-1,0x29,-3");
        fooWriter.close();
        System.out.println("#1: \"/etc/modules\" has been changed.");
        //------------------------ END -----------------------------------------

        //-------------------- Handling "/etc/modules" -------------------------
        file = new File("/boot/cmdline.txt");
        fooWriter = new FileWriter(file, false);
        fooWriter.write("dwc_otg.lpm_enable=0 console=ttyAMA0,115200 console=tty1 root=/dev/mmcblk0p2 rootfstype=ext4 elevator=deadline fbcon=map:10 fbcon=font:VGA8x8 FRAMEBUFFER=/dev/fb1 rootwait");
        fooWriter.close();
        System.out.println("#2: \"/boot/cmdline.txt\" has beem changed.");
        //------------------------ END -----------------------------------------

        //---------- Creating "/usr/share/X11/xorg.conf.d/99-fbdev.conf" -------
        file = new File("/usr/share/X11/xorg.conf.d/99-fbdev.conf");
        fooWriter = new FileWriter(file, false);
        fooWriter.write("Section \"Device\"  \n"
                + "  Identifier \"myfb\"\n"
                + "  Driver \"fbdev\"\n"
                + "  Option \"fbdev\" \"/dev/fb1\"\n"
                + "EndSection");
        fooWriter.close();
        System.out.println("#3 \"/usr/share/X11/xorg.conf.d/99-fbdev.conf\" has been created.");
        //------------------------------ END -----------------------------------
        System.out.println("Please reboot!");

    }

    public static void toDefault() throws IOException {
        //-------------------- Handling "/etc/modules" -------------------------
        File file = new File("/etc/modules");
        FileWriter fooWriter = new FileWriter(file, false); // true to append                                              // false to overwrite.
        fooWriter.write("# /etc/modules: kernel modules to load at boot time.\n"
                + "#\n"
                + "# This file contains the names of kernel modules that should be loaded\n"
                + "# at boot time, one per line. Lines beginning with \"#\" are ignored.\n"
                + "# Parameters can be specified after the module name.\n"
                + "\n"
                + "snd-bcm2835");
        fooWriter.close();
        System.out.println("#1: \"/etc/modules\" has been changed.");
        //------------------------ END -----------------------------------------

        //-------------------- Handling "/etc/modules" -------------------------
        file = new File("/boot/cmdline.txt");
        fooWriter = new FileWriter(file, false);
        fooWriter.write("dwc_otg.lpm_enable=0 console=ttyAMA0,115200 console=tty1 root=/dev/mmcblk0p2 rootfstype=ext4 elevator=deadline rootwait");
        fooWriter.close();
        System.out.println("#2: \"/boot/cmdline.txt\" has beem changed.");
        //------------------------ END -----------------------------------------

        //---------- Creating "/usr/share/X11/xorg.conf.d/99-fbdev.conf" -------
        file = new File("/usr/share/X11/xorg.conf.d/99-fbdev.conf");
        file.delete();
        System.out.println("#3 \"/usr/share/X11/xorg.conf.d/99-fbdev.conf\" has been deleted.");
        //------------------------------ END -----------------------------------

        System.out.println("Please reboot!");

    }

    public static void main(String[] args) throws IOException {
        if (args[0].equals("tft")) {
            toTft();
        } else if (args[0].equals("default")) {
            toDefault();
        }

    }
}
