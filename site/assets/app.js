const meters = document.querySelectorAll("meter");

meters.forEach((meter) => {
  const value = Number(meter.value);
  const max = Number(meter.max);
  const percent = Math.round((value / max) * 100);
  meter.setAttribute("title", `${percent}% of executed tests`);
});
