
$( "#ctsForm" ).submit(function( event ) {
    event.preventDefault();
    let sId = $("#studentId").val();
    let fn = $("#firstName").val();
    let gdn = $("#guardian").val();
    let dept = $("#department").val();
    let pn = $("#phoneNumber").val();
    let addr = $("#address").val();
    let chr = $("#charge").val();
    let rsn = $("#resolution").val();
    let rmks = $("#remarks").val();
  if( !( !sId || !fn || !gdn || !dept || !pn || !addr || !chr || !rsn || !rmks ||
              sId.trim().length < 1 || addr.trim().length < 1 || gdn.trim().length < 1 || dept.trim().length < 1
              || pn.trim().length < 1 || fn.trim().length < 1 || chr.trim().length < 1 || rsn.trim().length < 1
              || rmks.trim().length < 1 ) ){

      let val = {
        "studentId": sId,
        "firstName": fn,
        "guardian": gdn,
        "department": dept,
        "phoneNumber": pn,
        "address": addr,
        "charge": chr,
        "resolution": rsn,
        "remarks": rmks,
        "conductId": $("#conductInfoId").val() ? $("#conductInfoId").val() : null;
      }
      add(val);
  }else{
    alert(" All fields are mandatory, please make sure all fields have data to submit !!")
  }
});

function clearForm(){
    $("#studentId").val("");
    $("#firstName").val("");
    $("#guardian").val("");
    $("#department").val("");
    $("#phoneNumber").val("");
    $("#address").val("");
    $("#charge").val("");
    $("#resolution").val("");
    $("#remarks").val("");
}

function searchAction(){
    let studentId = $("#studentId").val();
    if( studentId && studentId.trim().length > 0){
        searchStudent(studentId)
    }else{
        alert(" Please enter valid Student Id")
    }
}

function searchStudent(studentId){
    $.ajax({
        url: "http://localhost:8080/student/details/"+studentId,
        success: function(result){
          loadTable(result.conductInfos);
          loadStudentDetails(result);
        },
        error: function(err) {
            console.log(err);
        }
    });
}

function loadStudentDetails(result){
    if( result ){
        $("#studentId").val(result.studentId);
        $("#firstName").val(result.firstName+" "+result.lastName);
        $("#guardian").val(result.guardianName);
        $("#department").val(result.department);
        $("#phoneNumber").val(result.phoneNumber);
        $("#address").val(result.address);
    }
}

function add(obj){
    $.ajax({
            url: "http://localhost:8080/student/create/data",
            data:obj,
            type:"POST"
            success: function(result){
              loadStudentDetails(result.student);
              if( result && result.conduct){
                 $("#charge").val(result.conduct.charge);
                 $("#resolution").val(result.conduct.resolution);
                 $("#remarks").val(result.conduct.remarks);
              }
            },
            error: function(err) {
                console.log(err);
            }
    });
}

function edit(conductInfoId ){
    $.ajax({
            url: "http://localhost:8080/conductinfo/details/"+conductInfoId,
            success: function(result){
              loadStudentDetails(result.student);
              if( result && result.conduct){
                 $("#charge").val(result.conduct.charge);
                 $("#resolution").val(result.conduct.resolution);
                 $("#remarks").val(result.conduct.remarks);
                 $("#conductInfoId").val(conductInfoId);
              }
            },
            error: function(err) {
                console.log(err);
            }
    });
}

function del( conductInfoId ){
    $.ajax({
        url: "http://localhost:8080/conductinfo/details/"+conductInfoId,
        type:"DELETE"
        success: function(result){
         let studentId = $("#studentId").val();
         searchStudent(studentId);
        },
        error: function(err) {
            console.log(err);
        }
    });
}

function loadTable(result){
    $('#dtBasicExample').DataTable({
        "lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]],
        "data":result,
        "columns": [
                    { "data": "facultyName" },
                    { "data": "semester" },
                    { "data": "charge" },
                    { "data": "resolution" },
                    { "data": "createdOn" },
                ],
       "columnDefs": [{
           "targets": 5,
           "data":"conductInfoId",
           "render": function ( data, type, row, meta ) {
             return '<a onClick="edit ('+data+')"> Edit </a> <a onClick="del('+data+')">Delete</a>';
           }
         }]

    });
    $('.dataTables_length').addClass('bs-select');
}