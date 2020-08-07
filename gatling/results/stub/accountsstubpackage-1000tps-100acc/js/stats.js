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
        "total": "1",
        "ok": "1",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "5455",
        "ok": "5455",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "401",
        "ok": "401",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1117",
        "ok": "1117",
        "ko": "-"
    },
    "percentiles1": {
        "total": "6",
        "ok": "6",
        "ko": "-"
    },
    "percentiles2": {
        "total": "13",
        "ok": "13",
        "ko": "-"
    },
    "percentiles3": {
        "total": "3734",
        "ok": "3734",
        "ko": "-"
    },
    "percentiles4": {
        "total": "4765",
        "ok": "4766",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 105170,
    "percentage": 88
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1222,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 13608,
    "percentage": 11
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
        "total": "1",
        "ok": "1",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "5455",
        "ok": "5455",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "401",
        "ok": "401",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1117",
        "ok": "1117",
        "ko": "-"
    },
    "percentiles1": {
        "total": "6",
        "ok": "6",
        "ko": "-"
    },
    "percentiles2": {
        "total": "13",
        "ok": "13",
        "ko": "-"
    },
    "percentiles3": {
        "total": "3733",
        "ok": "3733",
        "ko": "-"
    },
    "percentiles4": {
        "total": "4766",
        "ok": "4765",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 105170,
    "percentage": 88
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1222,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 13608,
    "percentage": 11
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
