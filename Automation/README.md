# Selenium Automation Framework

This automation layer is a lightweight SDET framework scaffold for Enterprise Operations Portal.

## Stack

- Java 17
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Page Object Model

## Design

| Layer | Responsibility |
|---|---|
| `base` | Browser setup, teardown, shared test lifecycle |
| `pages` | Page Object Model classes and UI interactions |
| `tests` | TestNG test classes with assertions |
| `utils` | Config, waits, and reusable helpers |
| `listeners` | Reporting and screenshot hooks |
| `resources` | TestNG XML and configuration |

## Commands

```bash
mvn test
mvn test -Dgroups=smoke
mvn test -Dgroups=regression
```

## Framework Notes

The `baseUrl` defaults to `local-demo`, which resolves to the working static demo app at `../site/demo/index.html`. Replace it with a deployed QA URL when connecting this scaffold to a real environment.

The structure is intentionally production-like: page objects do not contain test assertions, test classes do not expose raw locators, and browser setup is centralized.

