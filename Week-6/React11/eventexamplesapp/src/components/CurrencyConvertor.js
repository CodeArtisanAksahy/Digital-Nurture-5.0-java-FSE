import { useState } from 'react';

function CurrencyConvertor() {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const convertedAmount = amount * 101;
    alert(`Converting to ${currency} Amount is ${convertedAmount}`);
  };

  return (
    <div>
      <h2 style={{ color: 'blue' }}>Currency Convertor!!!</h2>
      <form onSubmit={handleSubmit}>
        <label>Amount:</label>
        <input type="text" value={amount} onChange={(e) => setAmount(e.target.value)}/><br />

        <label>Currency:</label>
        <textarea value={currency} onChange={(e) => setCurrency(e.target.value)}/><br />

        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default CurrencyConvertor;
