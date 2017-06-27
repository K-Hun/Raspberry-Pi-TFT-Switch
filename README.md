# Raspberry-Pi-TFT-Switch
This program configures ili9488 TFT display to work without changing kernel or flashing a custom version of Raspbian.
Instructions are according to this article : http://appdictive.dk/blog/projects/2015/10/30/cheap_tft_display_on_raspberry_pi/ , but you don't need to configure all steps manually, just build and run the program !

to use this program, first build a jar file from Main.java then :

# for switching to tft mode :
```
java -jar "PiTftSwitch.jar" tft
```


# for rolling back the configuration :
```
java -jar "PiTftSwitch.jar" default
```
