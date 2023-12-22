import logo from './logo.svg';
import './App.css';
import { CustomerProfileRegistration } from './components/Register';
import { CustomerProfileLogin } from './components/Login';
function App() {
  return (
    <div className="App">
      <CustomerProfileRegistration/>
      <CustomerProfileLogin/>
  <div className='row'>
    <div className='col'>
      <Routes>
        <Route path='' element={<div>Login Under Construction</div>}/>
        <Route path='/register' element={<CustomerProfileRegistration />}></Route>
        <Route path='/login' element={<CustomerProfileLogin />}></Route>
      </Routes>
    </div>
  </div>
    </div>
  );
}

export default App;
