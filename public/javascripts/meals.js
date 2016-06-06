function addRow() {
	$(".table").find('tbody')
    .append($('<tr>')
        .append($('<td>')
        	.append($('<input type="text" list="products">'))
        )
        .append($('<td>')
        	.append($('<input type="number" id="mealWeight" name="mealWeight" onchange="calculate()">'))
        )
        .append($('<td>')
        	.append($('<input type="number" id="calories" disabled>'))
        )
        .append($('<td>')
        	.append($('<input type="number" id="carb" disabled>'))
        )
        .append($('<td>')
        	.append($('<input type="number" id="fat" disabled>'))
        )        
        .append($('<td>')
        	.append($('<input type="number" id="protein" disabled>'))
        )
        .append($('<td>')
        	.append($('<input type="number" id="sugar" disabled>'))
        )
        .append($('<td>')
            .append($('<a class="btn btn-default">Dodaj</button>'))
        )   
    );
}

function calculate(){
    var weight = document.getElementById('mealWeight').value;
    document.getElementById('calories').value=weight;
    document.getElementById('carb').value=weight;
    document.getElementById('fat').value=weight;
    document.getElementById('protein').value=weight;
    document.getElementById('sugar').value=weight;
}