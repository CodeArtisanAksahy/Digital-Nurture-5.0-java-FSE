import BlogDetails from "./components/BlogDetails";
import BookDetails from "./components/BookDetails";
import CourseDetails from "./components/CourseDetails";
import { blogs, books, courses } from "./data";

function App() {

  return (
    <div>
      <div style={{ display: "flex", justifyContent: "space-around" }}>
        <BookDetails books={books} />
        <BlogDetails blogs={blogs} />
        <CourseDetails courses={courses} />
      </div>
    </div>
  );
}

export default App;
