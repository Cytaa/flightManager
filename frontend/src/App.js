import './App.css';
import Navbar from './Navbar'
import Maps from './components/Maps'
import Drawer from './Drawer'


function App() {
  return (
    <div className="App">
        <Navbar />
        <Drawer />
        <Maps />
    </div>
  );
}

export default App;
