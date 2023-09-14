# CARDOCR - Business Card Reader Application

## Overview

**CARDOCR** is a state-of-the-art Business Card Reader Application designed for the **Multimedia Project** in the **3rd Year, Second Semester**. This application leverages cutting-edge technology to simplify the process of extracting contact information from business cards, making it a valuable tool for professionals and businesses.

![CARDOCR App Screenshot](
![image](https://github.com/saraundre/Card-OCR/assets/110232966/ce172e29-1834-4c9a-9a0c-e5e57232aad1)
![image](https://github.com/saraundre/Card-OCR/assets/110232966/64e7160d-e8ab-4c87-bcdd-ad26f99d012b)
![image](https://github.com/saraundre/Card-OCR/assets/110232966/4dab3f00-c924-4dc8-b044-5fde88ba131a)
![image](https://github.com/saraundre/Card-OCR/assets/110232966/c72d33d1-ec47-4667-a84c-a75df2c4f1f8)
![image](https://github.com/saraundre/Card-OCR/assets/110232966/428eb25f-e342-4d05-ad2f-3fe98b7c5297)
![image](https://github.com/saraundre/Card-OCR/assets/110232966/f81e8aae-27bf-4b14-ad77-96e6ca3a2833)
![image](https://github.com/saraundre/Card-OCR/assets/110232966/a2e2ba03-9c04-4cc0-a2a8-a0f4c5abfb67)
![image](https://github.com/saraundre/Card-OCR/assets/110232966/4f42f034-1971-408b-9671-21718c58ca65)
![image](https://github.com/saraundre/Card-OCR/assets/110232966/b0183709-df92-43fa-9f90-cb18909df5ca)
![image](https://github.com/saraundre/Card-OCR/assets/110232966/8f27286d-45b0-475e-9454-446bebbeb4ad)
![image](https://github.com/saraundre/Card-OCR/assets/110232966/5c8c447b-094d-4217-84ba-bf4daf69fa0d)
)

## Objective

The primary objective of the **CARDOCR** project is to develop an application that can accurately recognize text from scanned business cards and extract essential entities such as names, phone numbers, and emails. Our goal is to automate the tedious process of manually entering contact information from business cards into the device's contacts.

## Requirements

To achieve our project's objective, we have established the following key requirements:

1. **Platform and Language**: Implement the application using Android Studio and the Kotlin programming language.

2. **Text Recognition**: Utilize the ML KIT API for text recognition to accurately extract text from images.

3. **Image Capture**: Incorporate CameraX for capturing images of business cards with ease.

4. **Entity Extraction**: Implement an Entity Extraction API to identify and extract specific entities from the recognized text.

5. **Permission Handling**: Utilize the Activity Result API for handling permissions, ensuring a seamless user experience.

6. **Multilingual Support**: Support multiple Latin-based languages for text recognition to cater to a diverse user base.

7. **User Interface**: Design an intuitive and user-friendly interface for capturing and processing business cards.

8. **Language Preferences**: Allow users to change the language preference for text recognition within the application.

9. **Contact Saving**: Enable users to save the recognized contact information directly to their device's contacts.

10. **Accuracy**: Ensure that recognized text is accurately extracted and categorized to minimize user editing.

## Environment

- **Operating System**: Windows XP
- **Integrated Development Environment (IDE)**: Android Studio
- **Programming Language**: Kotlin

## Project Components

### 1. Camera Module

- The application begins with a camera preview page upon launch.
- Users are prompted to grant permission for camera and device storage access.
- Once permission is granted, the device's camera is activated.
- Users can capture a picture of a business card.
- A progress dialog displays as the image is analyzed for text recognition.
- If text is detected, a contact details form is presented; otherwise, users are informed of no text detection.
- Users can edit the form as needed and save the contact, resulting in a system contact-saving confirmation.
- A successful save toast message is displayed.

### 2. Language Selector Interface

- Users can change the language preference for text recognition.
- A list of supported Latin-based languages is provided.
- Selecting a language triggers a notification of the language change at the bottom of the screen.

### 3. Progress Dialog Box

- A custom progress bar with SpinKit-based loading animation is employed.
- A text view displays "Extracting text" during the processing phase.

## Data

- The application is rigorously tested using various business card templates to ensure robust functionality.
- Testing encompasses image capture, text extraction, entity recognition, and contact saving verification.
- The application is thoroughly tested for supported Latin-based languages, including French and German.

## Major Procedures

### Camera Module

- The CameraX library is utilized to facilitate camera functionality.
- Use cases for Preview, Image Capture, and Image Analysis are thoughtfully implemented.
- Permissions for camera and storage are efficiently managed using ActivityResultContracts.

### Entity Extraction Module

- The Entity Extraction module harnesses ML Kit's power to recognize and extract entities from text.
- The module ensures the necessary ML model is downloaded (if not already) for seamless operation.
- Text is systematically annotated with specific entities such as phone numbers and emails.
- Annotated text with entities is effectively retrieved and processed for user convenience.

### Save Contact Module

- Robust validation checks are implemented to ensure that essential fields like name and mobile number are not left empty.
- Contact data is systematically saved using an Intent with the ACTION_INSERT action.
- This feature empowers users to add, edit, and save contact information effortlessly within their device's contacts app.

### Change Language Module

- Users are presented with a list of supported Latin-based languages to choose from.
- Changing the language preference seamlessly adjusts text recognition settings and triggers a notification confirming the language change.

## Conclusion

**CARDOCR** is a testament to the power of machine learning, specifically through the ML Kit API and CameraX integration, in developing a sophisticated and user-friendly business card reader application. It streamlines the process of digitizing business cards, ensuring high accuracy in text recognition and entity extraction. While further refinements and updates are anticipated, the project demonstrates its potential as a solution for simplifying contact entry and management.

---

