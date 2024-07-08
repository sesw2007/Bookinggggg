app.post('/registration', (req, res) => {
    // Обработка запроса
     res.set
});

app.get('/js/script.js', function(req, res) {
    res.setHeader('Content-Type', 'application/javascript');
    res.sendFile(__dirname + '/js/script.js');
});

const express = require('express');
const morgan = require('morgan');

const app = express();

// Logging middleware
app.use(morgan('dev'));

// Routes
app.post('/login', (req, res) => {
    // Your code here
});

// Error handling middleware
app.use((err, req, res, next) => {
    console.error(err.stack);
    res.status(500).send('Something broke!');
});

app.listen(8081, () => {
    console.log('Server is running on port 8081');
});

document.getElementById("registration-form").addEventListener("submit", function(event) {
    event.preventDefault();

    const Name = document.getElementById("Name").value;
    const Surname = document.getElementById("surname").value;
    const Patronymic = document.getElementById("patronymic").value;
    const country = document.getElementById("country").value;
    const city = document.getElementById("city").value;
    const Nick = document.getElementById("nick").value;
    const password = document.getElementById("password").value;
    const birthdate = document.getElementById("birthdate").value;
    const email = document.getElementById("email").value;

    console.log({
    Name,
    Surname,
        Patronymic,
    country,
    city,
    Nick,
    password,
    birthdate,
    email
});

    // Здесь можно добавить код для отправки данных формы на сервер
    // используя fetch или XMLHttpRequest.
});

// Get the button element
const rentButton = document.getElementById("rent-button");

// Add an event listener to the button
rentButton.addEventListener("click", generateRentalForm);

// Function to generate the rental form
function generateRentalForm() {
    // Create a new form element
    const rentalForm = document.createElement("form");
    rentalForm.setAttribute("id", "rental-form");

    // Add form fields
    const nameInput = document.createElement("input");
    nameInput.value = "Your Name";
    nameInput.type = "text";
    rentalForm.appendChild(nameInput);

    const emailInput = document.createElement("input");
    emailInput.value = "Your Email";
    emailInput.type = "email";
    rentalForm.appendChild(emailInput);

    const addressInput = document.createElement("input");
    addressInput.value = "Your Address";
    addressInput.type = "text";
    rentalForm.appendChild(addressInput);

    const startDateInput = document.createElement("input");
    startDateInput.value = "Start Date";
    startDateInput.type = "date";
    rentalForm.appendChild(startDateInput);

    const endDateInput = document.createElement("input");
    endDateInput.value = "End Date";
    endDateInput.type = "date";
    rentalForm.appendChild(endDateInput);

    const notesInput = document.createElement("textarea");
    notesInput.value = "Additional Notes";
    rentalForm.appendChild(notesInput);

    // Add a submit button
    const submitButton = document.createElement("button");
    submitButton.textContent = "Submit";
    rentalForm.appendChild(submitButton);

    // Add the form to the page
    document.body.appendChild(rentalForm);
}

// script.js
const loginForm = document.getElementById('login-form');
const usernameInput = document.getElementById('username');
const passwordInput = document.getElementById('password');

loginForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const username = usernameInput.value;
    const password = passwordInput.value;

    // Add your authentication logic here
    // For example, you can check if the username and password match a predefined array of users
    // If they match, redirect to a success page, otherwise display an error message
    if (username === 'admin' && password === 'password') {
        // window.location.href = 'success.html';
    } else {
        alert('Invalid username or password');
    }
});
// script.js
const rentalRequestForm = document.getElementById('rental-request-form');
rentalRequestForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const name = document.getElementById('name').value;
    const dateOfArrival = document.getElementById('date-of-arrival').value;
    const dateOfDeparture = document.getElementById('date-of-departure').value;
    const accommodationType = document.getElementById('accommodation-type').value;

    // Add your form submission logic here
    // For example, you can send the form data to a server-side script for processing
    console.log(`Rental Request Received: Name: ${name}, Date of Arrival: ${dateOfArrival}, Date of Departure: ${dateOfDeparture}, Accommodation Type: ${accommodationType}`);
});
// script.js
// script.js
const profileBtn = document.getElementById('profile-btn');
const profileInfo = document.getElementById('profile-info');

profileBtn.addEventListener('click', () => {
    const userName = "Andrey";
    const userEmail = "bvdsdsrfsf.com";

    profileInfo.innerHTML = `
        <h2>${userName}</h2>
        <p>${userEmail}</p>
    `;
});


// script.js
// Add an event listener to the submit button
document.getElementById("myForm").addEventListener("submit", function (event) {
    event.preventDefault();
    // Get the form data
    var formData = new FormData(this);
    // Send the form data to the server
    fetch("your-server-url", {
        method: "POST",
        body: formData
    })
        .then(function (response) {
            return response.text();
        })
        .then(function (data) {
            console.log(data);
            // Update the form status (e.g. show a success message)
        })
        .catch(function (error) {
            console.error(error);
            // Update the form status (e.g. show an error message)
        });
});
//Юзера
// Функция добавления по умолчанию пользователя
// отправка Get запрос
const addDefault = {name: 'ilya', email: 'gfhfhvhfhfh.com'};
fetch('http://localhost:8081/users/add-default', {
    method: 'Get',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(addDefault)
})

    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));
// Список пользователей
// отправка Get запросов
const getAllUserDTO = {name: 'Andrey', email: 'bvdsdsrfsf.com'}
fetch("http://localhost:8081/users/get-all", {
    method: 'Get',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(getAllUserDTO)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));
// Функции добавления нового пользователя
// отправка POST запрос
const newUser = {name: 'ludmila', email: 'gfhdgdhdhdh.com'};
fetch('http://localhost:8081/users/add-user', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(newUser)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));

// Delete user
const userId = 1;
fetch(`http://localhost:8081/users/delete-user`, {
    method: 'DELETE',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(userId)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));

// Изменение параметров  user
const userId = 1;
const edit = {name: 'Vitali', email: 'hgjfkytyt.com'};
fetch(`http://localhost:8081/users/edit`, {
    method: 'PUT',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(edit, userId)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));
//добавления по умолчание Жилье
const addDefault = {name: 'Квартира', city: 'Moscow', country: 'Russia'};
fetch('http://localhost:8081/housing/add-default', {
    method: 'Get',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(addDefault)
})

    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));
// Список жилья
// отправка Get запросов
const getAllHousingDTO = {name: 'Квартира', city: 'Moscow', country: 'Russia'}
fetch("htt://localhost:8081/housing/get-all", {
    method: 'Get',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(getAllHousingDTO)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));
// Функции добавления нового жилья
// отправка POST запрос
const newHousing = {name: 'Квартира', city: 'Moscow', country: 'Russia'};
fetch('http://localhost:8081/housing/add-housing', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(newHousing)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));

// Delete удаления жилья по айди
const housingId = 1;
fetch(`http://localhost:8081/housing/delete-housing`, {
    method: 'DELETE',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(housingId)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));

// Изменение параметров  жилья
const housingId = 1;
const edit = {name: 'Квартира', city: 'Moscow',
    country: 'Russia', price: "15000", rating: "1-10"};
fetch(`http://localhost:8081/housing/edit`, {
    method: 'PUT',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(edit, housingId)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));

//Поиск жилья по городу
const searchHousing = {city: "Cairo"}
fetch('http://localhost:8081/housing/search-housing', {
    method: 'Get',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(searchHousing)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));
//Поиск жилья по несколькими параметров
const searchHousings = {city: "Moscow", cite: " China", due_date: "2024 2 1", rating: "1-10", price: "15000"};
fetch('http://localhost:8081/housing/search-housings', {
    method: 'Get',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(searchHousings)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));


// Обьявления
//Добавления по умолчанию обьявления
let addDefault = {
    due_date: "2023 2 28",
    the_nearest_stop_metro: "красная звезда, локомотив",
    name: "Название обьявления"
};
fetch('http://localhost:8081/placeads/add-default', {
    method: 'Get',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(addDefault)
})

    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));

// Список обьявления
let getAllPlaceAdsDTO = {name: 'Квартира', city: 'Moscow', country: 'Russia'}
fetch("http://localhost:8081/placeads/get-all", {
    method: 'Get',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(getAllPlaceAdsDTO)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));


// Функции добавления нового обьявления

const newPlaceAds = {name: 'Квартира', city: 'Moscow', country: 'Russia'};
fetch('http://localhost:8081/placeads/add-placeads', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(newPlaceAds)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));


// Изменение параметров  обьявления

const placeAdsId = 1;
const edit = {name: 'Квартира', city: 'Moscow', country: 'Russia', price: "15000", rating: "1-10"};
fetch(`http://localhost:8081/placeads/edit`, {
    method: 'PUT',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(edit, placeAdsId)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));


// Delete удаления жилья по айди
const placeAdsId = 1;
fetch(`http://localhost:8081/placeads/delete-placeads`, {
    method: 'DELETE',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(placeAdsId)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));

//активное обявления
const activityPlaceAds = {true, false}

fetch(`http://localhost:8081/placeads/`, {
    method: 'Get',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(activityPlaceAds)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));

//Заявку на аренду
//добавления по умолчанию заявку на аренду
const addDefault = {name: 'Название', due_date: '2024 02 3'}
fetch('http://localhost:8081/applicationrent/add-default', {
    method: 'Get',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(addDefault)
})

    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));

//Список заявки на аренду
const getAllApplicataionRent = {name: 'Название', due_date: '2024 02 3', rating: '1-15', price: '6 000'}

fetch('http://localhost:8081/applicationrent/get-all', {
    method: 'Get',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(getAllApplicataionRent)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));

//Добавления нового заявка на аренду
const addNewApplicationRent = {name: 'Название', due_date: '2024 02 3', rating: '1-15', price: '6 000'}
fetch('http://localhost:8081/applicationrent/add-applicationrent', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(addNewApplicationRent)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));


// Удаления заявки аренду по id
const applicationId = 1;
fetch('http://localhost:8081/applicationrent/delete-applicationrent', {
    method: 'DELETE',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(applicationId)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));

// Изменения заявки на аренду
const applicationrentId = 1;
const edit = {name: 'Название', due_date: '2024 02 3', rating: '1-15', price: '6 000'}
fetch('http://localhost:8081/applicationrent/edit', {
    method: 'PUT',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(edit, applicationrentId)
})

    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));


//добавления нового роли
const addRole = {}
fetch("http://localhost:8081/roles/add-role", {
    method: "POST",
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(addRole)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));


// Список роли
const findAll = {}
fetch("http://localhost:8081/roles/findAll", {
    method: "POST",
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(findAll)
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));
