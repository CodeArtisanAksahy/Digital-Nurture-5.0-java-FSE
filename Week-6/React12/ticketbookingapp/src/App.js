import { useState } from 'react';
import User from './components/User';
import Guest from './components/Guest';
import Login from './components/Login';
import Logout from './components/Logout';

function App() {
  const [isLogIn, setIsLogIn] = useState(false);

  const handleLogin = () => setIsLogIn(true);
  const handleLogout = () => setIsLogIn(false);

  let page;
  if (isLogIn) {
    page = <User />;
  } else {
    page = <Guest />;
  }

  return (
    <div>
      <h1>Flight Booking Portal</h1>
      {page}
      {
        isLogIn
          ? <Logout onClick={handleLogout} />
          : <Login onClick={handleLogin} />
      }
    </div>
  );
}

export default App;
