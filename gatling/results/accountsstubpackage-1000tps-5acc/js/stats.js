var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "120000",
        "ok": "120000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "6135",
        "ok": "6135",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "390",
        "ok": "390",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1207",
        "ok": "1207",
        "ko": "-"
    },
    "percentiles1": {
        "total": "5",
        "ok": "5",
        "ko": "-"
    },
    "percentiles2": {
        "total": "11",
        "ok": "11",
        "ko": "-"
    },
    "percentiles3": {
        "total": "3972",
        "ok": "3972",
        "ko": "-"
    },
    "percentiles4": {
        "total": "5330",
        "ok": "5330",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 107718,
    "percentage": 90
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 551,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 11731,
    "percentage": 10
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "991.736",
        "ok": "991.736",
        "ko": "-"
    }
},
contents: {
"req_getaccountspack-16304": {
        type: "REQUEST",
        name: "getAccountsPackageFromStub",
path: "getAccountsPackageFromStub",
pathFormatted: "req_getaccountspack-16304",
stats: {
    "name": "getAccountsPackageFromStub",
    "numberOfRequests": {
        "total": "120000",
        "ok": "120000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "6135",
        "ok": "6135",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "390",
        "ok": "390",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1207",
        "ok": "1207",
        "ko": "-"
    },
    "percentiles1": {
        "total": "5",
        "ok": "5",
        "ko": "-"
    },
    "percentiles2": {
        "total": "11",
        "ok": "11",
        "ko": "-"
    },
    "percentiles3": {
        "total": "3972",
        "ok": "3972",
        "ko": "-"
    },
    "percentiles4": {
        "total": "5330",
        "ok": "5330",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 107718,
    "percentage": 90
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 551,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 11731,
    "percentage": 10
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "991.736",
        "ok": "991.736",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
