function Welcome() {
  const sayWelcome = (msg) => {
    alert(msg);
  };

  return (
    <div>
      <button onClick={() => sayWelcome("Welcome")}>Say welcome!!!</button>
    </div>
  );
}

export default Welcome;
