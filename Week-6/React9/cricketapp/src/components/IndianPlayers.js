import React from 'react';
import { OddPlayers } from './OddPlayers';
import { EvenPlayers } from './EvenPlayers';

const IndianPlayers = () => {
  const T20players = ['KL', 'Rohit', 'Surya', 'Hardik'];
  const RanjiPlayers = ['Pujara', 'Iyer', 'Yash', 'Kuldeep'];

  const allPlayers = [...T20players, ...RanjiPlayers];

  return (
    <div>
      <h2>All Indian Players</h2>
      <ul>
        {allPlayers.map((p) => <li>{p}</li>)}
      </ul>

      <h2>Odd Team Players</h2>
      <OddPlayers allPlayers={allPlayers}/>

      <h2>Even Team Players</h2>
      <EvenPlayers allPlayers={allPlayers}/>
    </div>
  );
};

export default IndianPlayers;
