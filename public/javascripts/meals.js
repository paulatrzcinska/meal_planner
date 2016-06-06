function addRow() {
	$(".table").find('tbody')
    .append($('<tr>')
        .append($('<td id="productName">')
        	.append($('<input type="text" list="products">'))
        )
        .append($('<td id="mealWeight">')
        	.append($('<input type="number" name="mealWeight" onchange="calculate(this)">'))
        )
        .append($('<td id="calories">')
        	.append($('<input type="number" disabled>'))
        )
        .append($('<td id="carb">')
        	.append($('<input type="number" disabled>'))
        )
        .append($('<td id="fat">')
        	.append($('<input type="number" disabled>'))
        )        
        .append($('<td id="protein">')
        	.append($('<input type="number" disabled>'))
        )
        .append($('<td id="sugar">')
        	.append($('<input type="number" disabled>'))
        )
        .append($('<td>')
            .append($('<a class="btn btn-default">Dodaj</button>'))
        )   
    );
}

function calculate(el) {
    var currentRowIndex = el.parentNode.parentNode.rowIndex;
    var productname = document.getElementById('meals-table').rows[currentRowIndex].cells.namedItem('productName').childNodes[0].value;
    //var productname = document.getElementById('productName').value;
    var weight = document.getElementById('meals-table').rows[currentRowIndex].cells.namedItem('mealWeight').childNodes[0].value;
    //var weight = document.getElementById('mealWeight').value;
    //document.getElementById('calories').value= products_list[productname]['calories'] * weight;
    document.getElementById('meals-table').rows[currentRowIndex].cells.namedItem('calories').childNodes[0].value=products_list[productname]['calories'] * weight;
    //document.getElementById('carb').value=products_list[productname]['carb'] * weight;
    document.getElementById('meals-table').rows[currentRowIndex].cells.namedItem('carb').childNodes[0].value=products_list[productname]['carb'] * weight;
    //document.getElementById('fat').value=products_list[productname]['fat'] * weight;
    document.getElementById('meals-table').rows[currentRowIndex].cells.namedItem('fat').childNodes[0].value=products_list[productname]['fat'] * weight;
    //document.getElementById('protein').value=products_list[productname]['protein'] * weight;
    document.getElementById('meals-table').rows[currentRowIndex].cells.namedItem('protein').childNodes[0].value=products_list[productname]['protein'] * weight;
   //document.getElementById('sugar').value=products_list[productname]['sugar'] * weight;
   document.getElementById('meals-table').rows[currentRowIndex].cells.namedItem('sugar').childNodes[0].value=products_list[productname]['sugar'] * weight;
}