import { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);

  const sayHello = () => {
    alert('Hello!!!!!!!!!!!!!!!!!!');
  };

  const showStaticMsg = () => {
    console.log('Here u get the Static Msg yo!!!!!!');
  };

  const handleIncrement = () => {
    setCount(prev => prev + 1);
    sayHello();
    showStaticMsg();
  };

  const handleDecrement = () => {
    setCount(prev => prev - 1);
  };

  return (
    <div>
      <h1>{count}</h1>
      <button onClick={handleIncrement}>Increment</button><br />
      <button onClick={handleDecrement}>Decrement</button>
    </div>
  );
}

export default Counter;
