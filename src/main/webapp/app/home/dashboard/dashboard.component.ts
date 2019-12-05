import {Component, OnInit} from '@angular/core';
import {Chart} from 'angular-highcharts';
import {LoginService} from 'app/core';
import {Router} from '@angular/router';
import {SEARCH_CRITERIA_URL, SLACE, DOWNLOAD_HISTORY_URL} from 'app/app.constants';

export const W2_EMPLOYEE_STATUS = 'W2 EMPLOYEE STATUS';
export const C2C_EMPLOYEE_STATUS = 'C2C EMPLOYEE STATUS';
export const TRANSPARENT = 'transparent';
export const W2 = 'W2';
export const C2C = 'C2C';
export const BENCH = 'Active Bench';
export const PERCENT_50 = '50%';
export const PERCENT_75 = '75%';
export const PERCENT_110 = '110%';
export const BOLD_STYLE = 'bold';
export const RELATIVE = 'relative';
export const FIXED = 'fixed';
export const PIXEL_15 = '15px';
export const POINTER = 'pointer';
export const INDEX_0 = 0;
export const INDEX_1 = 1;
export const HEIGHT_300 = 300;
export const MARGIN_60 = 60;
export const MARGIN_14 = 14;
export const ANGEL_90 = 90;
export const ANGEL_0 = 0;
export const MARGIN_0 = 0;
export const NAGATIVE_10 = -10;
export const NAGATIVE_5 = -5;
export const AXIS_30 = 30;
export const COLOR_1 = '#ff6361';
export const COLOR_2 = '#58508d';
export const COLOR_3 = '#ffa600';
export const COLOR_4 = '#3366ff';
export const COLOR_5 = '#41f4d9';
export const COLOR_6 = '#f44182';
export const COLORS: string[] = [COLOR_1, COLOR_2, COLOR_3, COLOR_4, COLOR_5, COLOR_6];
export const PERCENTAGES: string [] = [PERCENT_50, PERCENT_75];

@Component({
    selector: 'jhi-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss']
})

export class DashboardComponent implements OnInit {
    w2chart: Chart;
    c2cchart: Chart;
    w2status: any;
    c2cstatus: any;
    result: any;
    createChart: Chart;
    chartStatus: any;

    constructor(private loginService: LoginService, private router: Router) { }

    ngOnInit() {
        this.loginService.getDashboardData().subscribe(res => {
            // console.log('get dashboard data', res);
            this.dashBoardData(res);
        });
    }

    // Navigate to Employee Search Page
    searchEmp() {
        this.loginService.setSearchTypeReqData(null);
        this.loginService.searchStatusReq.next(null);
        this.router.navigate([SLACE, SEARCH_CRITERIA_URL]);
    }

    // Navigate to Employee Search Page and getting W2 Employees
    sendRequestW2TypeSearch() {
        this.loginService.searchTypeReq.next('2');
        this.loginService.searchStatusReq.next('2');
        this.router.navigate([SLACE, SEARCH_CRITERIA_URL]);
    }

    // Navigate to Employee Search Page and getting C2C Employees
    sendRequestC2CTypeSearch() {
        this.loginService.searchTypeReq.next('1');
        this.loginService.searchStatusReq.next('2');
        this.router.navigate([SLACE, SEARCH_CRITERIA_URL]);
    }

    // Chart with Datas
    dashBoardData(dbData: any) {
        console.log('database .. ', dbData);
        for (let i = 0; i < dbData.length; i++) {
            this.chartStatus = dbData[i].statusData;
            this.createChart = new Chart({
                chart: {
                    type: 'pie',
                    plotBackgroundColor: null,
                    marginLeft: MARGIN_14,
                    marginBottom: MARGIN_60,
                    height: HEIGHT_300,
                    backgroundColor: TRANSPARENT
                },
                credits: {
                    enabled: false
                },
                title: {
                    text: 'EMPLOYEE_STATUS',
                    margin: MARGIN_0,
                    style: {
                        fontSize: PIXEL_15
                    },
                    y: AXIS_30
                },
                plotOptions: {
                    pie: {
                        dataLabels: {
                            enabled: true,
                            distance: NAGATIVE_10,
                            style: {
                                fontWeight: BOLD_STYLE,
                                position: RELATIVE
                            }
                        },
                        colors: COLORS,
                        startAngle: ANGEL_90,
                        endAngle: ANGEL_0,
                        center: PERCENTAGES,
                        size: PERCENT_110,
                        innerSize: 0
                    }
                },
                series: [
                    {
                        name: 'employee chart',
                        type: 'pie',
                        data: dbData[i].data,
                        colorByPoint: true
                    }
                ]
            });
        }

        this.w2status = dbData[INDEX_0].statusData;
        this.c2cstatus = dbData[INDEX_1].statusData;
        this.w2chart = new Chart({
            chart: {
                type: dbData[INDEX_0].graph,
                plotBackgroundColor: null,
                marginLeft: MARGIN_14,
                marginBottom: MARGIN_60,
                height: HEIGHT_300,
                backgroundColor: TRANSPARENT // this.dbData.backgroundColor
                // spacingTop: 100
            },
            credits: {
                enabled: false
            },
            title: {
                text: W2_EMPLOYEE_STATUS,
                margin: MARGIN_0,
                style: {
                    fontSize: PIXEL_15
                },
                y: AXIS_30
            },
            plotOptions: {
                series: {
                    cursor: POINTER,
                    point: {
                        events: {
                            click() {
                                location.href = this.dbData[INDEX_0].url;
                            }
                        }
                    }
                },
                pie: {
                    dataLabels: {
                        enabled: true,
                        distance: NAGATIVE_5,
                        style: {
                            fontWeight: BOLD_STYLE,
                            position: FIXED
                        }
                    },
                    colors: COLORS,
                    startAngle: ANGEL_90,
                    endAngle: ANGEL_0,
                    center: PERCENTAGES,
                    size: PERCENT_110,
                    innerSize: dbData[INDEX_0].innerSize
                }
            },
            series: [
                {
                    name: dbData[INDEX_0].name,
                    type: dbData[INDEX_0].graph,
                    data: dbData[INDEX_0].data,

                    colorByPoint: true
                }
            ]
        });

        this.c2cchart = new Chart({
            chart: {
                type: dbData[1].graph,
                plotBackgroundColor: null,
                marginLeft: MARGIN_14,
                marginBottom: MARGIN_60,
                height: HEIGHT_300,
                backgroundColor: TRANSPARENT // this.dbData.backgroundColor
            },
            credits: {
                enabled: false
            },
            title: {
                text: C2C_EMPLOYEE_STATUS,
                margin: MARGIN_0,
                style: {
                    fontSize: PIXEL_15,
                    whiteSpace: '0'
                },
                y: AXIS_30
            },
            plotOptions: {
                pie: {
                    dataLabels: {
                        enabled: true,
                        distance: NAGATIVE_10,
                        style: {
                            fontWeight: BOLD_STYLE,
                            position: RELATIVE
                        }
                    },
                    colors: COLORS,
                    startAngle: ANGEL_90,
                    endAngle: ANGEL_0,
                    center: PERCENTAGES,
                    size: PERCENT_110,
                    innerSize: dbData[INDEX_1].innerSize
                }
            },
            series: [
                {
                    name: dbData[INDEX_1].name,
                    type: dbData[INDEX_1].graph,
                    data: dbData[INDEX_1].data,
                    colorByPoint: true
                }
            ]
        });
    }
}
