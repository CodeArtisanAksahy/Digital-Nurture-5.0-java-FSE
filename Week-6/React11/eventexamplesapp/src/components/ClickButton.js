function ClickButton() {
  const onPress = (e) => {
    alert('I was clicked');
  };

  return (
    <div>
      <button onClick={onPress}>Click on me</button>
    </div>
  );
}

export default ClickButton;
