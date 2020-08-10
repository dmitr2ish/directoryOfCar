$(function () {
    updateCarTable();

    $('#save').on('click', event => saveCar(event));
    $('#edit').on('click', event => editCar(event));
    $('#delete').on('click', event => deleteCar(event));
})

function editCar(e) {
    e.preventDefault();

    let editCar = {
        id: $('#deleteId').val(),
        licensePlate: $('#editLicensePlate').val(),
        brand: $('#editBrand').val(),
        model: $('#editModel').val(),
        color: $('#editColor').val(),
        yearOfManufacture: $('#editYear').val(),
        price: $('#editPrice').val()
    }

    $.ajax({
        url: '/api/car/update',
        type: 'PUT',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(editCar),
        complete: function () {
            $('#edit-modal').modal('hide')
            updateCarTable();
        }
    })
}

function deleteCar(e) {
    e.preventDefault();

    let id = $('#deleteId').val()

    $.ajax({
        url: '/api/car/delete',
        type: 'DELETE',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(id),
        complete: function () {
            $('#delete-modal').modal('hide')
            updateCarTable();
        }
    })
}

function saveCar(e) {
    e.preventDefault();

    let newCar = {
        licensePlate: $('#addLicensePlate').val(),
        brand: $('#addBrand').val(),
        model: $('#addModel').val(),
        color: $('#addColor').val(),
        yearOfManufacture: $('#addYear').val(),
        price: $('#addPrice').val()
    }

    $.ajax({
        url: '/api/car/add',
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(newCar),
        complete: function () {
            $('#list-tab').tab('show')
            updateCarTable();
        }
    })
}

function updateCarTable() {
    $('#cars').empty();
    $.ajax({
        type: 'GET',
        url: '/api/car/list',
        success: function (cars) {
            cars.forEach(car =>
                $('#cars')
                    .append("<tr> \
                                    <td>" + car.id + "</td> \
                                    <td>" + car.licensePlate + "</td> \
                                    <td>" + car.brand + "</td> \
                                    <td>" + car.model + "</td> \
                                    <td>" + car.color + "</td> \
                                    <td>" + car.yearOfManufacture + "</td> \
                                    <td>" + car.price + "</td> \
                                    <td><button type='button' class='btn btn-info' onclick='editCarForm(" + car.id + ")'>Edit</button></td> \
                                    <td><button type='button' class='btn btn-danger' onclick='deleteCarForm(" + car.id + ")'>Delete</button></td> \
                             </tr>"))
        }
    });
}

function editCarForm(id) {
    $.ajax({
        url: '/api/car/' + id,
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        success: function (car) {

            $('#editId').val(car.id);
            $('#editLicensePlate').val(car.licensePlate);
            $('#editBrand').val(car.brand);
            $('#editModel').val(car.model);
            $('#editColor').val(car.color);
            $('#editYear').val(car.yearOfManufacture);
            $('#editPrice').val(car.price);

            $('#edit-modal').modal('show');
        }
    })
}

function deleteCarForm(id) {
    $.ajax({
        url: '/api/car/' + id,
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        success: function (car) {

            $('#deleteId').val(car.id);
            $('#deleteLicensePlate').val(car.licensePlate);
            $('#deleteBrand').val(car.brand);
            $('#deleteModel').val(car.model);
            $('#deleteColor').val(car.color);
            $('#deleteYear').val(car.yearOfManufacture);
            $('#deletePrice').val(car.price);

            $('#delete-modal').modal('show');
        }
    })
}