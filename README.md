# 🤖 CodenBox Automation Project

This project demonstrates automation testing using **Selenium WebDriver** with **Java** and **TestNG** on the [CodenBox Automation Lab](https://codenboxautomationlab.com/practice/) website.  
The site contains various UI elements ideal for practicing automation testing. 💻🧪

---

## 🛠️ Tools & Technologies Used

- ☕ **Java** – Programming language  
- 🌐 **Selenium WebDriver** – For UI automation  
- 🧪 **TestNG** – Testing framework  
- ⚙️ **Maven** – Build tool & dependency manager  
- 🧭 **ChromeDriver** – For running tests in Chrome browser  

---

## ✅ Automated Test Cases

### `@Test(priority = 1)` – 🪟 **Window Handling**
- Opens a new window  
- Switches focus to it and performs validation  
- Closes the new window and returns to the original  

---

### `@Test(priority = 2)` – 🧾 **Tab Handling**
- Opens a new browser tab  
- Switches to it, validates the title or content  

---

### `@Test(priority = 3)` – ⚠️ **Alert Handling**
- Accepts/dismisses JS alerts  
- Sends text to prompt alerts  

---

### `@Test(priority = 4)` – 📊 **Table Data Interaction**
- Extracts and prints data from an HTML table  
- Useful for verifying row/column content  

---

### `@Test(priority = 5)` – ⬇️ **Dropdown Handling**
- Selects different options from a dropdown menu  
- Can verify the selected value  

---

### `@Test(priority = 6)` – 👁️‍🗨️ **Show/Hide Elements**
- Clicks a button to show/hide a text field  
- Verifies visibility of the element  

---

### `@Test(priority = 7)` – 📜 **Table Data Extraction**
- Scrolls to the table section  
- Extracts and prints specific rows/columns  
- Useful for validating displayed data  

---

### `@Test(priority = 8)` – 🎯 **Mouse Hover Action**
- Performs hover action on menu items  
- Verifies dropdown appearance upon hover  
- Helps test dynamic menus  

---

### `@Test(priority = 9)` – 🧮 **Checkbox & Radio Button**
- Selects checkboxes and radio buttons  
- Validates their selection status  
- Ensures user input elements behave correctly  

---

### `@Test(priority = 10)` – 🪟 **Window Handling**
- Clicks a button that opens a new window  
- Switches to the new window  
- Performs validation and closes it  

---

### `@Test(priority = 11)` – 📂 **Tab Switching**
- Clicks to open a link in a new tab  
- Switches between browser tabs  
- Verifies content in the new tab  

---

### `@Test(priority = 12)` – 🚨 **Alert Handling**
- Clicks to trigger different alert types  
- Accepts, dismisses, or sends input to alerts  
- Verifies alert behaviors and messages  

---

### `@Test(priority = 13)` – 🧩 **Iframe Handling**
- Scrolls to the bottom where the iframe is  
- Switches to the iframe  
- Interacts with the burger menu inside the iframe  

---

## ▶️ How to Run the Project

1. 🌀 Clone the repository  
2. 🧠 Open it in IntelliJ, Eclipse, or any Java IDE  
3. 🚀 Run `AppTest.java` using TestNG  

⚠️ Make sure:
- Java is installed ☕  
- Maven is installed ⚙️  
- ChromeDriver version matches your Chrome 🌐  

---

Built with 💙 for testing practice.
