var canvas = $x('//*[@id="main-content"]/div[2]/div/div[1]/div/form/div[5]/div/div[1]')[0];

$(canvas).removeClass('ng-hide');
$(canvas).html('');
$(canvas).height(400);

url = "http://q4de3qsy220.gdc-esn01.t-systems.com:16180/wrapper-webfrontend/processes/loadSteps/51";
srcData = [];
net = {
    post: function (url, dataMap, onSuccess, onError) {
        this._sendRequest(url, "POST", dataMap, onSuccess, onError);
    },
    _sendRequest: function (url, method, dataMap, onSuccess, onError) {
        $.ajax({
            url: url,
            type: method,
            data: dataMap,
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    if (onSuccess != null && onSuccess != undefined) {
                        onSuccess(data);
                    }
                } else {
                    if (onError != null && onError != undefined) {
                        onError(data);
                    } else {
                        alert('Error: ' + data.error);
                    }
                }
            }
        });
    }
};
net.post(url, null,
    function (data) {
        alert("Done.");
        d.data = data.data;
    }, function (data) {
        srcData = data.data;
    }
);

function findFirst(arr) {
    return arr.find(function (e) {
        return e.previousSteps.length == 0;
    });
}

function findById(data, id) {
    return data.find(function (el) {
        return el.id == id
    });
}

nodes = [];
edges = [];

function fill(el) {
    if (findById(nodes, el.id)) return;
    node = { id: el.id, label: str2multiline(el.name)};
    nodes.push(node);

    for (var i = 0; i < el.nextSteps.length; i++) {
        nextEl = el.nextSteps[i];
        edge = {from: el.id, to: nextEl.id, arrows: 'to'};
        edges.push(edge);
        fill(findById(srcData, nextEl.id));
    }
}
var rootNode = findFirst(srcData);
fill(rootNode);

$.getScript("https://cdnjs.cloudflare.com/ajax/libs/vis/4.21.0/vis.min.js", function () {
    console.log("Script loaded but not necessarily executed.");
});

function str2multiline(s) {
    var pr = false;
    var res = '';
    for (var i = 0; i < s.length; i++) {

        if (s.charAt(i) == ' ') {
            res = pr ? res + '\n' : res + ' ';
            pr = !pr;
        } else {
            res = res + s.charAt(i);
        }
    }
    return res;
}

$('<link/>', {
    rel: 'stylesheet',
    type: 'text/css',
    href: 'https://cdnjs.cloudflare.com/ajax/libs/vis/4.21.0/vis.min.css'
}).appendTo('head');

var data1 = {
    nodes: nodes,
    edges: edges
};
var options = {
    edges: {
        font: {
            size: 12
        }
    },
    nodes: {
        shape: 'box',
        margin: 5,
        widthConstraint: {
            maximum: 150
        }
    },
    physics: {
        enabled: false
    }
};

// initialize your network!
var network = new vis.Network(canvas, data1, options);