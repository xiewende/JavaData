//提交按钮触发添加事件
function add() {
    var listTbl = document.getElementById("list_tbl");
    var trEle = document.createElement("tr");
    var tdEle = document.createElement("td");
    //获取form表单数据的name
    var elements = ["book_id", "number", "book_name", "price", "author", "year", "ISBN", "button"];
    var isNull = false;

    // 1.获取并添加行内元素
    for (var i = 0; i < elements.length; i++) {
        tdEle = document.createElement("td");
        if (i != elements.length - 1) {
            var value = document.getElementById(elements[i]).value;
            if (value == "") {
                isNull = true;
            }
            var textNode = document.createTextNode(value);
            tdEle.appendChild(textNode);
        } else {
            var deleteButton = "<input type=\"button\" value=\"删除\" onclick=\"deleteRow(this);\">";
            tdEle.innerHTML = deleteButton;
        }
        trEle.appendChild(tdEle);
    }

    // 2.不空则整行插入表格
    if (!isNull) {
        listTbl.appendChild(trEle);
    } else {
        alert("输入信息不能为空");
    }


}

//删除按钮触发删除事件
function deleteRow(Ele) {
    // button -> td -> tr -> table
    Ele.parentNode.parentNode.parentNode.removeChild(Ele.parentNode.parentNode);
}