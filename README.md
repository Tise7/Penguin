

**Steps to access the file**

    1. Download the latest version of Android Studio Application and lunch the application
    2. From the Github link on your browser, click on Code. Either download the Zip File or Open with the Github Desktop application and clone the repository
    3. Open the downloaded file after unzipping in the Android Studio or click on "Open In Android Studio" after cloning the repository in the Github Desktop application


**Steps to Access the application**

     A. Running the App on an Emulator:

         Create an Android Virtual Device (AVD): If you don't have an existing AVD:
         Go to Tools -> AVD/Device Manager.
         Click "Create Virtual Device".
         Choose a device definition (e.g., Pixel 7) and click "Next".
         Select a system image (Android version) and click "Next". You will have to download a version preferably 34 or higher
         Configure AVD properties (name, orientation, etc.) and click "Finish".
         Select the AVD: In the toolbar, click the dropdown menu next to the green "Run" button and choose your AVD.
         Run the App: Click the green "Run" button (or press Shift + F10). Android Studio will build the app and launch it on the selected emulator.

    B. Running the App on a Physical Device:

         Method 1:
             Enable USB Debugging: On your Android device:
             Go to Settings -> About Phone -> Build Number.
             Tap on "Build Number" seven times to enable Developer Options.
             Go back to Settings -> System -> Developer Options.
             Enable "USB Debugging" on your device.
             Connect Device: Connect your device to your computer using a USB cable.
             Select the Device: In the toolbar, click the dropdown menu next to the green "Run" button and choose your connected device.
             Run the App: Click the green "Run" button (or press Shift + F10). Android Studio will build the app and install it on your device.
    
        Method 2:
             Click on the Device Manager
             Click on pair device using wifii 
             Ensure both devices are connected to the same wifi
             Enable "USB Debugging" on your phone
             Click on Debugging wifi to scan the QR code to pair the devices
