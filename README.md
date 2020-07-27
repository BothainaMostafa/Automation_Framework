# AutomationFramework
An automation framework which uses maven and testNG

## Installation
**Step 1** - Install Java on your computer

Download and install the Java Software Development Kit (JDK) [here](https://www.oracle.com/java/technologies/javase-downloads.html).

**Step 2** - Install Eclipse IDE

Download latest version of Eclipse IDE for Java Developers [here](https://www.eclipse.org/downloads/). Be sure to choose correctly between Windows 32 Bit and 64 Bit versions.

For more info [here](https://www.guru99.com/installing-selenium-webdriver.html).

## Usage
**Step 1** - ALM test cases creation

* Every bubble (say lemma) must have a step.
* Description column which corresponds user's input (**2nd column**), entries are of two types:
  * Free Text is written as is.
  * Button selection is written as ```Button_buttonName```
* Expected result column which corresponds TOBi's input (**3rd column**), entries are of three types:
  * Exact assertion is written as is.
  * PDFs or PNGs assertion is written as ```pdfName.PDF``` or ```pngName.PNG```
  * Ticket say lemma is in the format of ```incident_id```
* RHS column checks right hand side data if any (**4th column**), entires must be as follows:
  * No line spacing.
  * Edit message must be in the format of
  ```
   Edit
   If this isn't what you want, please click Edit.
* Links column checks contents of embedded hyperlink if any (**5th column**), in the format of ```https://myitshop.internal.vodafone.com/citrix```
* Hint column checks hint message in text box if any (**6th column**).

**Step 2** - TestNG code creation

* Create a java class in tests package.
* Import libraries in the format of ```import org.testng.annotations.AfterMethod;```
* Create a BeforeMethod function contains userLogin function.
* Pass to the function the login data file path and name.
* Create a Test function per each test case contains genericTestCase function.
* Pass to the function the test case file path and name.
* Don't forget to repeat for each test case.
* Create a AfterMethod function contains userLogout that closes the driver.

**Important note** Every file path are being read from the project directory.

## Roadmap
### 1. Create batch file that creates testNG systematic code automatically.
### 2. Future enhancements aim to check number of parameters that needs manual intervention:

Screenshots in RHS.

Progress bar.

Help button.

Disclaimer message.

Survey link.

## Contributing
Pull requests are welcome. Please make sure to update tests 
