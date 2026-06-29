# Enterprise QA Validation Suite

![QA Portfolio](https://img.shields.io/badge/QA-Enterprise%20Testing-0f766e)
![STLC](https://img.shields.io/badge/STLC-Complete-2563eb)
![Manual Testing](https://img.shields.io/badge/Manual%20Testing-100%2B%20Scenarios-7c3aed)
![Automation](https://img.shields.io/badge/Automation-Selenium%20Java-d97706)
![Reports](https://img.shields.io/badge/Reports-Executive%20Ready-16a34a)

Enterprise QA Validation Suite is a production-style SDET portfolio project that demonstrates how a QA team validates a realistic enterprise web application from requirements through manual execution, defect management, regression, reporting, and automation planning.

The project is intentionally built like a real software-company QA repository: requirements, test strategy, IEEE-style test plan, RTM, manual test cases, defect reports, smoke/regression suites, execution reports, JIRA workflow examples, and a Selenium Java TestNG automation framework scaffold.

## Live Portfolio Dashboard

Open the deployable dashboard locally:

[site/index.html](C:/Users/edith/OneDrive/Desktop/Automation2/site/index.html)

Open the working demo application under test:

[site/demo/index.html](C:/Users/edith/OneDrive/Desktop/Automation2/site/demo/index.html)

For GitHub Pages, set Pages source to GitHub Actions. The workflow in `.github/workflows/pages.yml` publishes the `/site` folder.

## Application Under Test

The simulated application is **Enterprise Operations Portal**, a role-based enterprise web application with:

- Authentication and password reset
- Dashboard and operational metrics
- Profile management
- User management
- Search and filtering
- Notifications
- Reports and exports
- Settings
- Role management and authorization
- File upload
- Payment workflow using a mocked gateway

## Portfolio Highlights

| Area | Evidence |
|---|---|
| Requirements Analysis | Functional requirements, business rules, risks, assumptions |
| Test Planning | Test strategy and IEEE-style test plan |
| Traceability | Requirement Traceability Matrix mapping requirements to cases |
| Manual Testing | 100+ scenarios and 60 detailed test cases |
| Defect Management | 20 realistic bugs with severity, priority, root cause, repro rate |
| Agile QA | JIRA workflow, issues, sprint-ready QA artifacts |
| Reporting | Daily, weekly, execution, metrics, and closure reports |
| Automation | Selenium Java TestNG Maven architecture using Page Object Model |
| Deployment | Static dashboard ready for GitHub Pages |

## Repository Structure

```text
.
├── docs/                         # Requirements, SDLC/STLC, QA blueprint summaries
├── TestPlan/                     # Test strategy and IEEE-style test plan
├── RTM/                          # Requirement traceability matrix
├── TestCases/                    # Manual test cases and test suites
├── BugReports/                   # Defect log and sample bug reports
├── Jira/                         # JIRA workflow and issue examples
├── Reports/                      # Execution, status, metrics, and closure reports
├── Automation/                   # Selenium Java TestNG framework scaffold
├── Screenshots/                  # Evidence placeholders
├── site/                         # Deployed portfolio dashboard
├── .github/workflows/            # GitHub Pages deployment workflow
└── Enterprise-QA-Validation-Suite-Blueprint.md
```

## Key Metrics

| Metric | Value |
|---|---:|
| Functional Requirements | 26 |
| User Stories | 11 |
| Test Scenarios | 110 |
| Manual Test Cases | 60 |
| Smoke Tests | 20 |
| Sanity Tests | 15 |
| Defects Logged | 20 |
| Automation Candidates | 42 |
| Requirement Coverage | 100% |

## Automation Architecture

The automation scaffold uses:

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Page Object Model
- Extent Reports-ready listener structure
- Smoke and regression suite grouping

See [Automation/README.md](C:/Users/edith/OneDrive/Desktop/Automation2/Automation/README.md).

Verified local automation run:

```text
mvn test
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
Build: SUCCESS
```

## This project demonstrates that you can:



- Convert business requirements into testable acceptance criteria.
- Design risk-based manual testing coverage.
- Maintain traceability between requirements, tests, and execution.
- Write professional defects that developers can reproduce.
- Report quality using executive-friendly metrics.
- Identify which tests should be automated and why.
- Design a maintainable Selenium framework instead of writing throwaway scripts.

## Roadmap

| Phase | Status | Outcome |
|---|---|---|
| QA Blueprint | Complete | End-to-end enterprise testing plan |
| Manual QA Artifacts | Complete | Test cases, scenarios, RTM, data, bugs |
| Portfolio Dashboard | Complete | Recruiter-friendly deployed view |
| Automation Scaffold | Complete | Java/Selenium/TestNG framework |
| Real App Binding | Planned | Connect automation to a live demo AUT |
| CI Test Execution | Planned | Run automated smoke tests in GitHub Actions |

## License

MIT License. See [LICENSE](C:/Users/edith/OneDrive/Desktop/Automation2/LICENSE).

