function CourseDetails({ courses }) {
  let content;

  if (courses.length > 0) {
    content = (
      <ul>
        {courses.map((course) => (
          <li>
            <h3>{course.name}</h3>
            <p>{course.date}</p>
          </li>
        ))}
      </ul>
    );
  } else {
    content = <p>No course data available</p>;
  }

  return (
    <div>
      <h1>Course Details</h1>
      {content}
    </div>
  );
}

export default CourseDetails;