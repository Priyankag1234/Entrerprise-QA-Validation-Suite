const users = {
  "valid.user@corp.com": { name: "Valid User", role: "employee" },
  "admin@corp.com": { name: "Admin User", role: "admin" },
  "manager@corp.com": { name: "Manager User", role: "manager" }
};

let currentUser = null;

const views = {
  login: document.querySelector("#login-view"),
  dashboard: document.querySelector("#dashboard-view"),
  "admin-users": document.querySelector("#admin-users-view"),
  reports: document.querySelector("#reports-view")
};

const showView = (name) => {
  Object.values(views).forEach((view) => view.classList.add("hidden"));
  views[name].classList.remove("hidden");
};

const requireLogin = (route) => {
  if (!currentUser) {
    showView("login");
    return;
  }
  showView(route);
};

document.querySelector("[data-test='login-submit']").addEventListener("click", () => {
  const email = document.querySelector("#email").value.trim();
  const password = document.querySelector("#password").value;
  const error = document.querySelector("[data-test='login-error']");

  if (!users[email] || password !== "Secure@2026QA") {
    error.textContent = "Invalid email or password.";
    return;
  }

  error.textContent = "";
  currentUser = users[email];
  document.querySelector("[data-test='current-user']").textContent = currentUser.name;
  const adminWidget = document.querySelector("[data-test='admin-widget']");
  adminWidget.classList.toggle("hidden", currentUser.role !== "admin");
  showView("dashboard");
});

document.querySelector("[data-test='logout']").addEventListener("click", () => {
  currentUser = null;
  showView("login");
});

document.querySelectorAll("[data-route]").forEach((button) => {
  button.addEventListener("click", () => requireLogin(button.dataset.route));
});

document.querySelector("[data-test='create-user']").addEventListener("click", () => {
  document.querySelector("#user-form").classList.remove("hidden");
});

document.querySelector("[data-test='save-user']").addEventListener("click", () => {
  const email = document.querySelector("#user-email").value.trim();
  const firstName = document.querySelector("#first-name").value.trim();
  const lastName = document.querySelector("#last-name").value.trim();
  const success = document.querySelector("[data-test='toast-success']");

  if (!email || !firstName || !lastName) {
    success.textContent = "";
    return;
  }

  const row = document.createElement("tr");
  row.innerHTML = `<td>${email}</td><td>${firstName} ${lastName}</td><td>Active</td>`;
  document.querySelector("#users-table").appendChild(row);
  success.textContent = "User created successfully.";
  document.querySelector("#user-form").classList.add("hidden");
});

document.querySelector("[data-test='generate-report']").addEventListener("click", () => {
  const startDate = document.querySelector("#start-date").value;
  const endDate = document.querySelector("#end-date").value;
  const error = document.querySelector("[data-test='date-error']");
  const reportTable = document.querySelector("[data-test='report-table']");

  if (!startDate || !endDate || startDate > endDate) {
    reportTable.classList.add("hidden");
    error.textContent = "Start date must be before end date.";
    return;
  }

  error.textContent = "";
  reportTable.classList.remove("hidden");
});

showView("login");
