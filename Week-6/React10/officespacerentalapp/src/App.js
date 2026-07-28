import React from "react";
import "./App.css";

function App() {
  const element = "Office Space";

  const jsxatt = (
    <img
      src="modern-office.webp"
      width="25%"
      height="25%"
      alt="Office Space"
    />
  );

  const item = { Name: "DBS", Rent: 50000, Address: "Chennai" };

  let colors = [];
  if (item.Rent <= 60000) {
    colors.push("textRed");
  } else {
    colors.push("textGreen");
  }

  return (
    <div>
      <h1>{element}, at Affordable Range</h1>
      <div>
        {jsxatt}
        <h1>Name: {item.Name}</h1>
        <h3 className={colors.join(" ")}>Rent: Rs. {item.Rent}</h3>
        <h3>Address: {item.Address}</h3>
      </div>
    </div>
  );
}

export default App;
