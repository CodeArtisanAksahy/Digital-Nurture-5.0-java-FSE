export function OddPlayers({ allPlayers }) {
  const [first, , third, , fifth] = allPlayers;
  return (
    <ul>
      <li>First: {first}</li>
      <li>Third: {third}</li>
      <li>Fifth: {fifth}</li>
    </ul>
  );
}