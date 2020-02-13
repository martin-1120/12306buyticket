(function (x) {
    jQuery.extend({
        ht_getcookie: function (O) {
            var N = document.cookie.indexOf(O);
            var M = document.cookie.indexOf(";", N);
            return N == -1 ? "" : unescape(document.cookie.substring(N + O.length + 1, (M > N ? M : document.cookie.length)))
        }, ht_setcookie: function (S, R, Q, P, N, O) {
            var M = new Date();
            M.setTime(M.getTime() + Q * 1000);
            document.cookie = escape(S) + "=" + escape(R) + (M ? "; expires=" + M.toGMTString() : "") + (P ? "; path=" + P : "; path=/") + (N ? "; domain=" + N : "") + (O ? "; secure" : "")
        }, textFocus: function (O) {
            var N, M, O = O === undefined ? 0 : parseInt(O);
            this.each(function () {
                if (!this.setSelectionRange) {
                    N = this.createTextRange();
                    O === 0 ? N.collapse(false) : N.move("character", O);
                    N.select()
                } else {
                    M = this.value.length;
                    O === 0 ? this.setSelectionRange(M, M) : this.setSelectionRange(O, O)
                }
                this.focus()
            });
            return this
        }
    });
    var s = [];
    var y = [];
    var z = [];
    var A = [];
    var r = 0;
    var t = 0;
    var v = 0;
    var J = 0;
    var K = false;
    var f = false;
    var B = false;
    var u = 0;
    var C = null;
    var i = -1;
    var e = [];
    var d = [];
    var c = [];
    var b = [];
    var L = [];
    var p = [];
    var o = [];
    var m = [];
    var l = [];
    var k = [];
    var E = [];
    var a = false;
    var F = true;
    var q = 30;
    var g = "简码/汉字";
    var j = "简码/汉字";
    var n = "inp-txt_select";
    var h = "inp-txt";
    var w = false;
    var D = null;
    var I = null;
    var G = false;
    var H = x.ht_getcookie("hj_favcity");
    x.stationFor12306 = {
        bindInputs: [],
        get_initInputValue: function () {
            return g
        }, get_initTopInputValue: function () {
            return j
        }, city_Bind: function (N) {
            if (N.length == 0) {
                return
            }
            var M = "";
            x.each(N, function (O) {
                if (H == N[O][2]) {
                    M += "<div class='cityline' id='citem_" + O + "' cturn='" + N[O][6] + "'><span class='ralign'><b>" + N[O][1] + "</b></span></div>\n"
                } else {
                    M += "<div class='cityline' id='citem_" + O + "' cturn='" + N[O][6] + "'><span class='ralign'>" + N[O][1] + "</span></div>\n"
                }
            });
            x("#panel_cities").html(M);
            x(".cityline").mouseover(function () {
                x.stationFor12306.city_shiftSelect(this)
            }).click(function () {
                x.stationFor12306.city_confirmSelect();
                z = x.stationFor12306.filterCity("");
                x.stationFor12306.city_showlist(0)
            });
            x.stationFor12306.city_shiftSelect(x("#citem_0"))
        }, city_changeSelectIndex: function (M) {
            var N = v + M;
            if (N == -1) {
                x.stationFor12306.city_showlist(u - 1);
                x.stationFor12306.city_shiftSelect(x("#citem_" + (A.length - 1)))
            } else {
                if (N == A.length) {
                    x.stationFor12306.city_showlist(u + 1);
                    x.stationFor12306.city_shiftSelect(x("#citem_0"))
                } else {
                    x.stationFor12306.city_shiftSelect(x("#citem_" + N))
                }
            }
        }, city_confirmSelect: function () {
            C.val(J[1]);
            curObjCode.val(J[2]);
            if (w) {
                x.stationFor12306.setStationInCookies(J[1], J[2])
            }
            x("#form_cities").css("display", "none");
            x("#form_cities2").css("display", "none");
            x("#form_cities3").css("display", "none");
            i = -1;
            t = 0;
            x.stationFor12306.setStationStyle();
            if (F) {
                x.stationFor12306.LoadJS(J[2])
            }
            if (D) {
                D(C, curObjCode)
            }
        }, city_shiftSelect: function (N) {
            if (r != N) {
                if (r != 0) {
                    x(r).removeClass("citylineover").addClass("cityline").css("backgroundColor", "white")
                }
                if (N != 0) {
                    try {
                        r = N;
                        var M = x(r).removeClass("cityline").addClass("citylineover").css("backgroundColor", "#c8e3fc");
                        v = Number(M.attr("id").split("_")[1]);
                        J = s[Number(M.attr("cturn"))];
                        x("#cityid").val(J[2])
                    } catch (O) {}
                }
            }
        }, city_shiftSelectInLi: function (M) {
            if (t != M) {
                if (t != 0) {
                    x(t).removeClass("ac_over").addClass("ac_odd")
                }
                if (M != 0) {
                    try {
                        t = M;
                        x(t).removeClass("ac_odd").addClass("ac_over")
                    } catch (N) {}
                }
            }
        }, js: function (N) {
            var M;
            for (M = 1; M <= 7; M++) {
                if (M == N) {
                    x("#ul_list" + M).css("display", "block");
                    x("#nav_list" + M).addClass("action");
                    if (M == 1 || M == 7) {
                        x("#flip_cities2").css("display", "none")
                    }
                    if (M > 1 && M < 7) {
                        var P = x.stationFor12306.tHtmlGetCityName(N - 1, -1, 0);
                        if (P > q) {
                            var O = Math.ceil((P + 1) / q);
                            if (O > 1) {
                                x.stationFor12306.pageDesigh(O, 0, M)
                            }
                            x("#flip_cities2").css("display", "block")
                        } else {
                            x("#flip_cities2").css("display", "none")
                        }
                    } else {
                        C.focus()
                    }
                } else {
                    x("#ul_list" + M).css("display", "none");
                    x("#nav_list" + M).removeClass("action")
                }
            }
            if (1 != N) {
                x(".ac_even").on("mouseover", function () {
                    x.stationFor12306.city_shiftSelectInLi(this)
                }).on("click", function () {
                    C.val(x(this).text());
                    curObjCode.val(x(this).attr("data"));
                    if (w) {
                        x.stationFor12306.setStationInCookies(x(this).text(), x(this).attr("data"))
                    }
                    x("#form_cities2").css("display", "none");
                    i = -1;
                    t = 0;
                    x.stationFor12306.setStationStyle();
                    if (F) {
                        x.stationFor12306.LoadJS(x(this).attr("data"))
                    }
                    if (D) {
                        D(C, curObjCode)
                    }
                })
            }
        }, tHtmlGetCityName: function (N, M, P) {
            switch (N) {
            case 0:
                if (M == -1) {
                    return y.length
                }
                if (M == -2) {
                    return y
                }
                return y[M];
                break;
            case 1:
                if (M == -1) {
                    return e.length
                }
                if (M == -2) {
                    return e
                }
                if (e.length > q) {
                    var O = Math.ceil((e.length + 1) / q);
                    if (O > 1) {
                        p = e.slice(q * (P), Math.min(q * (P + 1), e.length));
                        return p[M]
                    }
                }
                return e[M];
                break;
            case 2:
                if (M == -1) {
                    return d.length
                }
                if (M == -2) {
                    return d
                }
                if (d.length > q) {
                    var O = Math.ceil((d.length + 1) / q);
                    if (O > 1) {
                        o = d.slice(q * (P), Math.min(q * (P + 1), d.length));
                        return o[M]
                    }
                }
                return d[M];
                break;
            case 3:
                if (M == -1) {
                    return c.length
                }
                if (M == -2) {
                    return c
                }
                if (c.length > q) {
                    var O = Math.ceil((c.length + 1) / q);
                    if (O > 1) {
                        m = c.slice(q * (P), Math.min(q * (P + 1), c.length));
                        return m[M]
                    }
                }
                return c[M];
                break;
            case 4:
                if (M == -1) {
                    return b.length
                }
                if (M == -2) {
                    return b
                }
                if (b.length > q) {
                    var O = Math.ceil((b.length + 1) / q);
                    if (O > 1) {
                        l = b.slice(q * (P), Math.min(q * (P + 1), b.length));
                        return l[M]
                    }
                }
                return b[M];
                break;
            case 5:
                if (M == -1) {
                    return L.length
                }
                if (M == -2) {
                    return L
                }
                if (L.length > q) {
                    var O = Math.ceil((L.length + 1) / q);
                    if (O > 1) {
                        k = L.slice(q * (P), Math.min(q * (P + 1), L.length));
                        return k[M]
                    }
                }
                return L[M];
                break;
            default:
                return "error";
                break
            }
        }, closeShowCity: function () {
            x("#form_cities2").css("display", "none");
            i = -1;
            t = 0;
            x.each(x.stationFor12306.bindInputs, function (Q, P) {
                var O = "#" + P;
                var N = "#" + P + "Text";
                var M = x(N).val();
                if ("" == M) {
                    x(N).val(g);
                    x.stationFor12306.from_to_station_class_gray(x(N));
                    x(O).val("")
                }
            })
        }, showAllCity: function () {
            var T = "";
            var N = "370px";
            if (w) {
                N = "400px"
            }
            T = '<div class="com_hotresults" id="thetable" style="width:' + N + '"><div style="width:100%;"><div class="ac_title"><span>拼音支持首字母输入</span><a class="ac_close" style="cursor:pointer" title="关闭" onclick="$.stationFor12306.closeShowCity()"></a></div><ul class="AbcSearch clx" id="abc">';
            if (w) {
                T = T + '<li class="action" index="7" method="liHotTab"  onclick="$.stationFor12306.js(7)" id="nav_list7">常用</li>'
            }
            T = T + '<li index="1" method="liHotTab"  onclick="$.stationFor12306.js(1)" id="nav_list1">热门</li><li index="2" method="liHotTab"  onclick="$.stationFor12306.js(2)" id="nav_list2">A－E</li><li index="3" method="liHotTab"  onclick="$.stationFor12306.js(3)" id="nav_list3">F－J</li><li index="4" method="liHotTab"  onclick="$.stationFor12306.js(4)" id="nav_list4">K－O</li><li index="5" method="liHotTab"  onclick="$.stationFor12306.js(5)" id="nav_list5">P－T</li><li index="6" method="liHotTab"  onclick="$.stationFor12306.js(6)" id="nav_list6">U－Z</li></ul>';
            if (w) {
                T += '<ul class="popcitylist" style="overflow: auto;max-height: 280px;height: 191px;" method="hotData" id="ul_list7">';
                var U = x.stationFor12306.getStationInCookies();
                var Q = U.length;
                if (Q > 2) {
                    G = true;
                    for (var V = 0; V < Q; V++) {
                        T += '<li class="ac_even"   title="' + U[V][0] + '" data="' + U[V][1] + '">' + U[V][0] + "</li>"
                    }
                }
                T += "</ul>"
            }
            T += '<ul class="popcitylist" style="overflow: auto;max-height: 280px;height: 191px;display:none;" method="hotData" id="ul_list1">';
            var P = x.stationFor12306.tHtmlGetCityName(0, -1, 0);
            var S = "";
            if (!w) {
                S = " openLi"
            }
            for (var V = 0; V < P; V++) {
                T += '<li class="ac_even' + S + '"   title="' + x.stationFor12306.tHtmlGetCityName(0, V, 0)[1] + '" data="' + x.stationFor12306.tHtmlGetCityName(0, V, 0)[2] + '">' + x.stationFor12306.tHtmlGetCityName(0, V, 0)[1] + "</li>"
            }
            T += "</ul>";
            for (var W = 2; W <= 6; W++) {
                var R = W - 1;
                var M = x.stationFor12306.tHtmlGetCityName(R, -1, 0);
                if (M > q) {
                    var O = Math.ceil((M + 1) / q);
                    if (O > 1) {
                        T += '<ul  class="popcitylist" style="overflow: auto; max-height: 260px; height: 170px;display:none;" id="ul_list' + W + '">';
                        x.stationFor12306.pageDesigh(O, 0, W)
                    }
                    x("#flip_cities2").css("display", "block")
                } else {
                    T += '<ul  class="popcitylist" style="overflow: auto; max-height: 260px; height: 191px;display:none;" id="ul_list' + W + '">';
                    x("#flip_cities2").css("display", "none");
                    var S = "";
                    if (!w) {
                        S = " openLi"
                    }
                    for (var V = 0; V < x.stationFor12306.tHtmlGetCityName(R, -1, 0); V++) {
                        T += '<li class="ac_even' + S + '"   title="' + x.stationFor12306.tHtmlGetCityName(R, V, 0)[1] + '" data="' + x.stationFor12306.tHtmlGetCityName(R, V, 0)[2] + '">' + x.stationFor12306.tHtmlGetCityName(R, V, 0)[1] + "</li>"
                    }
                }
                T += "</ul>"
            }
            T += '<div id="flip_cities2"> 翻页控制区</div>';
            T += "</div>";
            x("#panel_cities2").html(T);
            x("#thetable").on("click", function () {
                if (x("#form_cities2").css("display") == "block") {
                    if (i == 1 | i == 0) {
                        i == -1
                    }
                    C.select()
                }
            });
            x("#form_cities").on("click", function () {
                if (x("#form_cities").css("display") == "block") {
                    if (i == 1 | i == 0) {
                        i == -1
                    }
                    C.select()
                }
            });
            x(".ac_even").on("mouseover", function () {
                x.stationFor12306.city_shiftSelectInLi(this)
            }).on("click", function () {
                C.val(x(this).text());
                curObjCode.val(x(this).attr("data"));
                if (w) {
                    x.stationFor12306.setStationInCookies(x(this).text(), x(this).attr("data"))
                }
                x("#form_cities2").css("display", "none");
                i = -1;
                t = 0;
                x.stationFor12306.setStationStyle();
                if (F) {
                    x.stationFor12306.LoadJS(x(this).attr("data"))
                }
                if (D) {
                    D(C, curObjCode)
                }
            });
            x("#flip_cities2").css("display", "none");
            return s
        }, LoadJS: function (O) {
            if (((typeof (mm_addjs) != "undefined")) && ("" != mm_addjs) && (mm_addjs == 1)) {
                var N = document.getElementsByTagName("HEAD").item(0);
                var M = document.createElement("SCRIPT");
                M.src = mm_srcjs + O + ".js";
                M.type = "text/javascript";
                N.appendChild(M)
            }
        }, pageDesigh: function (R, T, S) {
            var P = "";
            if (R > 1) {
                if (T == -1) {
                    T = (R - 1)
                } else {
                    if (T == R) {
                        T = 0
                    }
                }
                E = x.stationFor12306.tHtmlGetCityName(S - 1, -2, 0).slice(q * (T), Math.min(q * (T + 1), x.stationFor12306.tHtmlGetCityName(S - 1, -2, 0).length));
                var Q = "";
                if (!w) {
                    Q = " openLi"
                }
                for (var N = 0; N < E.length; N++) {
                    var O = E[N];
                    P += '<li class="ac_even' + Q + '"   title="' + O[1] + '" data="' + O[2] + '">' + O[1] + "</li>"
                }
                x("#ul_list" + S).html(P);
                var M = (T == 0) ? "&laquo;&nbsp;上一页" : "<a style='cursor:pointer'    class='cityflip' onclick='$.stationFor12306.pageDesigh(" + R + "," + (T - 1) + "," + S + ");return false;'>&laquo;&nbsp;上一页</a>";
                M += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;";
                M += (T == R - 1) ? "下一页&nbsp;&raquo;" : "<a style='cursor:pointer' class='cityflip'  onclick='$.stationFor12306.pageDesigh(" + R + "," + (T + 1) + "," + S + ")'>下一页&nbsp;&raquo;</a>";
                x("#flip_cities2").html(M);
                if (i == 1 | i == 0 | i == 2) {
                    i == -1
                }
                if (C) {
                    C.select()
                }
            } else {}
            x(".ac_even").on("mouseover", function () {
                x.stationFor12306.city_shiftSelectInLi(this)
            }).on("click", function () {
                C.val(x(this).text());
                curObjCode.val(x(this).attr("data"));
                if (w) {
                    x.stationFor12306.setStationInCookies(x(this).text(), x(this).attr("data"))
                }
                x("#form_cities2").css("display", "none");
                i = -1;
                t = 0;
                x.stationFor12306.setStationStyle();
                if (F) {
                    x.stationFor12306.LoadJS(x(this).attr("data"))
                }
                if (D) {
                    D(C, curObjCode)
                }
            })
        }, filterCity: function (P) {
            if (P.length == 0) {
                x("#top_cities").html(j);
                return s
            }
            var N = [];
            var M = /[^A-z]/.test(P);
            for (var O = 0; O < s.length; O++) {
                if (x.stationFor12306.isMatchCity(s[O], P, M)) {
                    N.push(s[O])
                }
            }
            if (N.length > 0) {
                x("#top_cities").html('按"<font color=red>' + P + '</font>"检索：');
                return N
            } else {
                x("#top_cities").html("无法匹配:<font color=red>" + P + "</font>");
                return []
            }
        }, replaceChar: function (M, O, N) {
            return M.substr(0, O) + N + M.substr(O + 1, M.length - 1)
        }, isMatchCity: function (R, U, O) {
            var U = U.toLowerCase();
            var N = [R[4].toLowerCase(), R[1], R[3].toLowerCase()];
            var T = -1;
            var Q = -1;
            if (O) {
                U = U.split("");
                for (var P = 0; P < U.length; P++) {
                    var W = N[1].indexOf(U[P]);
                    if (W > T && W <= P) {
                        N[1] = x.stationFor12306.replaceChar(N[1], W, "-");
                        T = W
                    } else {
                        return false
                    }
                }
            } else {
                U = U.split("");
                var M = true;
                var S = true;
                for (var P = 0; P < U.length; P++) {
                    var W = N[0].indexOf(U[P]);
                    if (W > T && W <= P) {
                        N[0] = x.stationFor12306.replaceChar(N[0], W, "-");
                        T = W
                    } else {
                        M = false;
                        break
                    }
                }
                for (var P = 0; P < U.length; P++) {
                    var V = N[2].indexOf(U[P]);
                    if (V > Q && V <= P) {
                        N[2] = x.stationFor12306.replaceChar(N[2], V, "-");
                        Q = V
                    } else {
                        S = false;
                        break
                    }
                }
                if ((M == false) && (S == false)) {
                    return false
                }
            }
            return true
        }, city_showlist: function (O) {
            if (z.length > 6) {
                var N = Math.ceil((z.length + 1) / 6);
                if (O == -1) {
                    O = (N - 1)
                } else {
                    if (O == N) {
                        O = 0
                    }
                }
                A = z.slice(6 * (O), Math.min(6 * (O + 1), z.length));
                x.stationFor12306.city_Bind(A);
                var M = (O == 0) ? "<span style='float:left;'>&laquo;&nbsp;向前</span>" : "<a style='float:left;cursor:pointer' href='' class='cityflip' onclick='$.stationFor12306.city_showlist(" + (O - 1) + ");return false;'>&laquo;&nbsp;向前</a>";
                M += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                M += (O == N - 1) ? "<span style='float:right;'>向后&nbsp;&raquo;</span>" : "<a style='float:right;cursor:pointer' href='' class='cityflip' onclick='$.stationFor12306.city_showlist(" + (O + 1) + ");return false;'>向后&nbsp;&raquo;</a>";
                x("#flip_cities").html(M);
                x("#flip_cities").css("display", "block")
            } else {
                O = 0;
                A = z;
                x.stationFor12306.city_Bind(A);
                x("#flip_cities").css("display", "none")
            }
            u = O;
            if (x("#form_cities").css("display") == "block") {
                a = true;
                C.focus()
            }
        }, fixDivBugInIE6: function (M) {
            try {
                M.bgiframe();
                if (M.width() > x("> ul", M).width()) {
                    M.css("overflow", "hidden")
                } else {
                    x("> iframe.bgiframe", M).width(x("> ul", M).width());
                    M.css("overflow", "scroll")
                } if (M.height() > x("> ul", M).height()) {
                    M.css("overflow", "hidden")
                } else {
                    x("> iframe.bgiframe", M).height(x("> ul", M).height());
                    M.css("overflow", "scroll")
                }
            } catch (N) {}
        }, clearStation: function (M) {
            i = -1;
            var O = C.val();
            var P = curObjCode.val();
            if (O == "" || P == "") {
                C.val("");
                curObjCode.val("")
            } else {
                var N = O + "|" + P;
                if (typeof (station_names) != "undefined") {
                    if (station_names.indexOf(N) == -1) {
                        C.val("");
                        curObjCode.val("")
                    } else {
                        if ("click" == M) {
                            C.select();
                            if (x("#form_cities").is(":hidden")) {
                                x("#form_cities2").css("display", "block")
                            }
                        }
                    }
                } else {
                    C.val("");
                    curObjCode.val("")
                }
            }
        }, MapCityID: function (N) {
            for (var M = 0; M < s.length; M++) {
                if (s[M][1] == N) {
                    return s[M][2]
                }
            }
            return 0
        }, MapCityName: function (M) {
            for (var N = 0; N < s.length; N++) {
                if (s[N][2] == M) {
                    return s[N][1]
                }
            }
            return ""
        }, SetISPos: function (Q) {
            if (I) {
                I(x("#form_cities"), x("#form_cities2"))
            } else {
                x("#form_cities").css("left", Q.position().left);
                x("#form_cities").css("top", Q.position().top + Q.height() + 12);
                x("#form_cities2").css("left", Q.position().left);
                x("#form_cities2").css("top", Q.position().top + Q.height() + 12)
            }
            var P = Q.offset().top;
            var M = x("#search_div");
            var N = x("#choice_div");
            M.css("top", P);
            N.css("top", P);
            var O = Q.offset().left;
            M.css("left", O);
            N.css("left", O)
        }, myHandlerFg: function (M) {
            if (M == null) {
                M.keyCode = 9
            } else {
                if (!M.which && M.which == 13) {
                    M.preventDefault()
                } else {
                    if (M.which && M.keyCode == 13) {
                        M.which = 9
                    }
                }
            }
        }, myHandler2: function (M) {
            if (M == null) {
                M = window.event;
                M.returnValue = false
            } else {
                if (M.which && M.which == 13) {
                    var O = document.getElementById("Upload_Data3");
                    if (document.createEvent) {
                        var N = document.createEvent("MouseEvents");
                        N.initEvent("click", true, false);
                        O.dispatchEvent(N)
                    } else {
                        if (document.createEventObject) {
                            O.fireEvent("onclick")
                        }
                    }
                } else {
                    if (!M.which && M.which == 13) {
                        M.preventDefault()
                    }
                }
            }
        }, from_to_station_class_plain: function (M) {
            if (h && h != "") {
                M.removeClass(h)
            }
            if (n && n != "") {
                M.addClass(n)
            }
        }, from_to_station_class_gray: function (M) {
            if (n && n != "") {
                M.removeClass(n)
            }
            if (h && h != "") {
                M.addClass(h)
            }
        }, setStationStyle: function () {
            var M = C.val();
            if (M == "") {
                C.val(g);
                x.stationFor12306.from_to_station_class_gray(C);
                curObjCode.val("")
            } else {
                x.stationFor12306.from_to_station_class_plain(C)
            }
        }, setCurValue: function () {
            C.val(J[1]);
            curObjCode.val(J[2])
        }, bindEvent: function (M) {
            var O = "#" + M;
            var N = "#" + M + "Text";
            x(N).keydown(function (Q) {
                C = x(N);
                curObjCode = x(O);
                i = 0;
                a = true;
                F = true;
                x("#form_cities2").css("display", "none");
                t = 0;
                var P = x(N).width();
                if (-[1, ]) {
                    P = P - 4
                }
                x("#form_cities").css("width", P);
                x("#form_cities").css("display", "block");
                x(".AbcSearch li").removeClass("action");
                x(".popcitylist").css("display", "none");
                if (G && w) {
                    x("#ul_list7").css("display", "block");
                    x("#nav_list7").addClass("action")
                } else {
                    x("#nav_list1").addClass("action");
                    x("#ul_list1").css("display", "block")
                }
                x("#flip_cities2").css("display", "none");
                x(".ac_even").removeClass("ac_over").addClass("ac_odd");
                Q = Q || window.event;
                if (Q.keyCode == 40) {
                    x.stationFor12306.city_changeSelectIndex(1);
                    x("#form_cities").css("display", "block");
                    x.stationFor12306.SetISPos(C);
                    x.stationFor12306.setCurValue()
                } else {
                    if (Q.keyCode == 38) {
                        x.stationFor12306.city_changeSelectIndex(-1);
                        x.stationFor12306.setCurValue();
                        x("#form_cities").css("display", "block");
                        x.stationFor12306.SetISPos(C)
                    } else {
                        if (Q.keyCode == 13) {
                            x.stationFor12306.city_confirmSelect();
                            if (document.addEventListener) {
                                document.addEventListener("keypress", x.stationFor12306.myHandlerFg, true)
                            } else {
                                evt = window.event;
                                evt.keyCode = 9
                            }
                        }
                    }
                }
            }).focus(function () {
                F = true;
                if (a) {
                    x("#form_cities2").css("display", "none");
                    t = 0;
                    a = false;
                    i = -1
                } else {
                    if (i == -1) {
                        x(".AbcSearch li").removeClass("action");
                        x(".popcitylist").css("display", "none");
                        x("#flip_cities2").css("display", "none");
                        if (G && w) {
                            x("#ul_list7").css("display", "block");
                            x("#nav_list7").addClass("action")
                        } else {
                            x("#nav_list1").addClass("action");
                            x("#ul_list1").css("display", "block")
                        }
                        x(".ac_even").removeClass("ac_over").addClass("ac_odd");
                        x("#form_cities2").css("display", "block")
                    }
                }
                C = x(N);
                curObjCode = x(O);
                i = 0;
                K = true;
                x.stationFor12306.SetISPos(C)
            }).blur(function () {
                C = x(N);
                curObjCode = x(O);
                i = 0;
                a = false;
                F = true;
                if (!f && !B) {
                    x.stationFor12306.clearStation("blur");
                    K = false;
                    x("#form_cities").css("display", "none");
                    x("#form_cities2").css("display", "none");
                    i = -1;
                    t = 0;
                    z = x.stationFor12306.filterCity("");
                    x.stationFor12306.city_showlist(0);
                    x.stationFor12306.setStationStyle()
                }
            }).keyup(function (P) {
                C = x(N);
                curObjCode = x(O);
                i = 0;
                a = true;
                P = P || window.event;
                if (P.keyCode != 40 && P.keyCode != 38 && P.keyCode != 37 && P.keyCode != 39 && P.keyCode != 13 && P.keyCode != 9) {
                    z = x.stationFor12306.filterCity(C.val());
                    x.stationFor12306.city_showlist(0)
                }
            }).click(function () {
                x.stationFor12306.clearStation("click")
            });
            x.stationFor12306.bindInputs.push(M)
        }, getStationInCookies: function () {
            var O = [];
            var N = x.ht_getcookie("_city_name_save_station");
            if (N) {
                var M = N.split(",");
                if (M && M.length > 0) {
                    x.each(M, function (S, R) {
                        var P = R.split("#");
                        var Q = [];
                        Q[0] = P[0];
                        Q[1] = P[1];
                        O[S] = Q
                    })
                }
            }
            return O
        }, setStationInCookies: function (W, N) {
            var T = x.stationFor12306.getStationInCookies();
            var Q = [];
            var X = T.length;
            var P = true;
            var Y = 10;
            for (var R = 0; R < X; R++) {
                if (T[R][0] == W && T[R][1] == N) {
                    P = false
                }
                Q.push(T[R])
            }
            if (P) {
                Q.push([W, N])
            }
            var S = Q;
            var O = "";
            var U = S.length;
            var R = 0;
            if (U > Y) {
                R = 1
            }
            var M = R;
            if (U > 1) {
                x("#ul_list7").html("");
                G = true
            }
            var V = "";
            for (; R < U; R++) {
                if (R > M) {
                    O += ","
                }
                O += S[R][0] + "#" + S[R][1];
                if (G && w) {
                    V += '<li class="ac_even" onmouseover="$.stationFor12306.city_shiftSelectInLi(this);" onclick="$.stationFor12306.li_click(this);"   title="' + S[R][0] + '" data="' + S[R][1] + '">' + S[R][0] + "</li>"
                }
            }
            if (G && w) {
                x("#ul_list7").html(V)
            }
            x.ht_setcookie("_city_name_save_station", O, 365 * 24 * 60 * 60)
        }, li_click: function (M) {
            C.val(x(M).text());
            curObjCode.val(x(M).attr("data"));
            if (w) {
                x.stationFor12306.setStationInCookies(x(M).text(), x(M).attr("data"))
            }
            x("#form_cities2").css("display", "none");
            i = -1;
            t = 0;
            x.stationFor12306.setStationStyle();
            if (F) {
                x.stationFor12306.LoadJS(x(M).attr("data"))
            }
            if (D) {
                D(C, curObjCode)
            }
        }, init: function (R, S) {
            if (typeof (S) != "undefined") {
                if (typeof (S._init_input) != "undefined") {
                    g = S._init_input
                }
                if (typeof (S._top_4_initInput) != "undefined") {
                    j = S._top_4_initInput
                }
                if (typeof (S.confirmCallBack) != "undefined") {
                    D = S.confirmCallBack
                }
                if (typeof (S._selected_class) != "undefined") {
                    n = S._selected_class
                }
                if (typeof (S._unselected_class) != "undefined") {
                    h = S._unselected_class
                }
                if (typeof (S._12306_openFavorite) != "undefined") {
                    w = S._12306_openFavorite
                }
                if (typeof (S.position) != "undefined") {
                    I = S.position
                }
            }
            if (typeof (station_names) != "undefined") {
                var O = station_names.split("@");
                for (var N = 0; N < O.length; N++) {
                    var Q = O[N];
                    var P = Q.toString().charAt(0);
                    if (P == "a" || P == "b" || P == "c" || P == "d" || P == "e") {
                        e.push(Q.split("|"))
                    }
                    if (P == "f" || P == "g" || P == "h" || P == "i" || P == "j") {
                        d.push(Q.split("|"))
                    }
                    if (P == "k" || P == "l" || P == "m" || P == "n" || P == "o") {
                        c.push(Q.split("|"))
                    }
                    if (P == "p" || P == "q" || P == "r" || P == "s" || P == "t") {
                        b.push(Q.split("|"))
                    }
                    if (P == "u" || P == "v" || P == "w" || P == "x" || P == "y" || P == "z") {
                        L.push(Q.split("|"))
                    }
                    if (Q.length > 0) {
                        Q = Q.split("|");
                        if (H != "" && Q[2] == H) {
                            favcity = Q;
                            s.unshift(Q);
                            if (N > 6) {
                                s.push(Q)
                            }
                        } else {
                            s.push(Q)
                        }
                    }
                }
                for (var N = 0; N < s.length; N++) {
                    s[N].push(N)
                }
            }
            if (typeof (favorite_names) != "undefined") {
                var M = favorite_names.split("@");
                for (var N = 0; N < M.length; N++) {
                    var Q = M[N];
                    if (Q.length > 0) {
                        Q = Q.split("|");
                        y.push(Q)
                    }
                }
                for (var N = 0; N < y.length; N++) {
                    y[N].push(N)
                }
            }
            z = x.stationFor12306.filterCity("");
            x.stationFor12306.city_showlist(0);
            x.stationFor12306.showAllCity();
            a = false;
            x.stationFor12306.fixDivBugInIE6(x("#form_cities"));
            x.stationFor12306.fixDivBugInIE6(x("#form_cities2"));
            if (R && R.length > 0) {
                x.each(R, function (U, T) {
                    x.stationFor12306.bindEvent(T)
                })
            }
            x("#form_cities").mousedown(function () {
                f = true
            }).mouseup(function () {
                f = false
            });
            x("#form_cities2").mousedown(function () {
                B = true
            }).mouseup(function () {
                B = false
            })
        }
    }
})(jQuery);
(function () {
    $.stopStation = function (a) {
        var b = this;
        b.init = function () {
            b.options = $.extend({}, $.stopStation.defaultOptions, a);
            if (null == b.options.url || null == b.options.getSearchDate) {
                throw "error options,url can not be null"
            }
            b.options.mouseOnPanel = 0;
            if (!$("#" + b.options.showDivId)[0]) {
                var d = [];
                var c = -1;
                d[++c] = '<div class="station" style="display:none;" id="' + b.options.showDivId + '"><b></b>';
                d[++c] = '<div class="station-info" id="' + b.options.showTitleId + '"></div>';
                d[++c] = '<div class="station-hd"><span class="zx">站序</span><span class="zm">站名</span><span class="dzsj">到站时间</span>';
                d[++c] = '<span class="cfsj">出发时间</span><span class="tlsj">停留时间</span>';
                d[++c] = '<a id="_stopStation_close_id" class="close" title="关闭" href="javascript:" </a></div>';
                d[++c] = '<div class="station-bd"><table><tbody id="' + b.options.showTableId + '"></tbody></table></div></div>';
                $(d.join("")).appendTo($("body:eq(0)"));
                $("#_stopStation_close_id").on("click", b.close)
            }
            $("#" + b.options.showDivId).css("z-index", "20001");
            if (b.options.mouseOutClose) {
                $("#" + b.options.showDivId).on("mouseenter", function (e) {
                    b.options.mouseOnPanel = 1
                }).on("mouseleave", function () {
                    b.options.mouseOnPanel = 0;
                    $("#" + b.options.showDivId).hide().appendTo($("body:eq(0)"));
                    $("#" + b.options.showTableId).html("")
                })
            }
        };
        b.close = function () {
            $("#" + $.stopStation.defaultOptions.showDivId).closest("tr").removeAttr("style");
            $("#" + $.stopStation.defaultOptions.showDivId).removeAttr("style");
            b.options.mouseOnPanel = 0;
            $("#" + $.stopStation.defaultOptions.showDivId).hide().appendTo($("body:eq(0)"));
            $("#" + $.stopStation.defaultOptions.showTableId).html("")
        };
        b.open = function (f, j, h, e, i, c) {
            $("#" + $.stopStation.defaultOptions.showDivId).attr("style", "z-index:20001");
            if (a.timer) {
                clearTimeout(a.timer)
            }
            var g = a.getSearchDate();
            if (i && "" != i && null != i) {
                var d = formatDate(i);
                if ("-" != d) {
                    g = formatDate(i)
                } else {
                    g = a.getSearchDate()
                }
            } else {
                g = a.getSearchDate()
            }
            $.ajax({
                url: a.url,
                type: "get",
                isTakeParam: false,
                beforeSend: function (k) {
                    k.setRequestHeader("If-Modified-Since", "0");
                    k.setRequestHeader("Cache-Control", "no-cache")
                }, data: {
                    train_no: j,
                    from_station_telecode: h,
                    to_station_telecode: e,
                    depart_date: g
                }, success: function (p) {
                    var t = p.data.data;
                    if (t && t.length > 0) {
                        var r = [];
                        var u = -1;
                        for (var q = 0; q < t.length; q++) {
                            var l = t[q];
                            if (q == 0) {
                                var n = null;
                                n = l.train_class_name;
                                var s = l.service_type;
                                if ("0" == s) {
                                    c = "无空调"
                                } else {
                                    c = "有空调"
                                } if (!n) {
                                    n = "&nbsp;&nbsp;"
                                }
                                $("#" + $.stopStation.defaultOptions.showTitleId).html('<span class="item1">' + l.station_train_code + '次      </span><span class="item2">' + l.start_station_name + "<em>--></em>" + l.end_station_name + '</span><span class="item3">' + n + '</span><span class="item4">' + c + "</span>").find("span").css("color", "#333")
                            }
                            var m = "";
                            if (!l.isEnabled) {
                                m = " style='color: #999;' "
                            }
                            r[++u] = '<tr><td width="50" class="tc" ' + m + ">" + l.station_no + "</td>";
                            r[++u] = '<td width="75" ' + m + ">" + l.station_name + "</td>";
                            r[++u] = '<td width="75" ' + m + ">" + l.arrive_time + "</td>";
                            r[++u] = '<td width="75" ' + m + ">" + l.start_time + "</td>";
                            r[++u] = "<td " + m + ">" + l.stopover_time + "</td></tr>"
                        }
                        $("#" + $.stopStation.defaultOptions.showTableId).html(r.join(""));
                        var o = $("#" + $.stopStation.defaultOptions.appendTo + f);
                        $("#" + $.stopStation.defaultOptions.showDivId).appendTo(o).show();
                        $(".ticket-info").filter("div").attr("style", "");
                        o[0].style["z-index"] = 19999;
                        if (!(navigator.appVersion.indexOf("MSIE 6") > -1)) {} else {}
                    }
                }
            })
        };
        b.init();
        myStopStation = b;
        return b
    };
    $.fn.stopStation = function () {
        return (new $.stopStation(Array.prototype.slice.call(arguments)[0]))
    };
    $.stopStation.defaultOptions = {
        url: null,
        mouseOutClose: false,
        showDivId: "train_div_",
        showTableId: "train_table_",
        showTitleId: "train_span_",
        appendTo: "train_num_",
        getSearchDate: null
    }
})();
var myStopStation = function () {};
var formatDate = function (b) {
    if (b && (b.length == 8)) {
        var c = b.substring(0, 4);
        var d = b.substring(4, 6);
        var a = b.substring(6, 8);
        return c + "-" + d + "-" + a
    } else {
        return "-"
    }
};
var checkusermdId;
var showTrainStop;
var hideTrainStop;
var showTicketPrice;
var isInitQueryInput = false;
var isInitStationDiv = false;
var isInitJsrenderTemplate = false;
var isInitDateRange = false;
var tickets_info;
var location_code;
var md5Str;
var leftTicketStr;
var isAsync;
var box;
var countDown = null;
var ischeckAutoSubmitCode = true;
var firstShow = 1;
var endShow = 20;
var dataNumber = 0;
var change_dates_arr = [];
var isOther = true;
var dwTranTimeStr;
var ydTranTimeStr;
var uninputmsg = "用户名／邮箱／手机号";
(function () {
    if ("N" == isMobileCheck) {
        uninputmsg = "用户名／邮箱"
    }
    var a;
    var aL = null;
    var bi;
    var a7;
    var J;
    var X;
    var bM;
    var bx;
    var o = false;
    var bF = 0;
    var am;
    var aV;
    var v;
    var V;
    var bS;
    var aS = new Array();
    var bu = new Array();
    var bE = new Array();
    var Q = new Array();
    var bp = new Array();
    var G;
    var ar = new Array();
    tickets_info = new Array();
    var aM = true,
        bG = true,
        aH = true,
        an = "starttime";
    var aq = true;
    var be = [];
    var aY = [];
    var bw = [];
    var az;
    var D = [];
    var bv = "";
    var bK = "";
    var aQ = "";
    var g = "";
    var B = "";
    $(document).ready(function () {
        $.init_ul4li();
        f();
        R();
        w();
        U();
        C();
        ao();
        aO();
        bc();
        clickCheckBoxName();
        bh();
        bz();
        ah();
        Y();
        bH();
        y();
        aG();
        bl();
        $("#float").headerFloat();
        $(window).scroll(function () {
            if (aL != null && (!aL.isHidden())) {
                $("#floatTable").hide();
                $(window).scrollTop(a)
            }
        });
        $.stopStation({
            url: ctx + "czxx/queryByTrainNo",
            getSearchDate: function () {
                return train_tour_flag == "fc" ? $.trim($("#back_train_date").val()) : $.trim($("#train_date").val())
            }
        });
        aU();
        bW();
        bI();
        n();
        N();
        W();
        bv = $("#fromStationText").val();
        bK = $("#toStationText").val();
        $("#showOnlyTicA").bind("click", function () {
            $("#filterTic").attr("checked", "checked");
            aZ();
            $jpopup.startOrHiden()
        });
        az = $.autoSubmit();
        var b0 = $("#train_date").val();
        var bY = $("#back_train_date").val();
        if (bY == "") {
            $("#back_train_date").val(b0)
        } else {
            $("#back_train_date").val(bY)
        }
        r();
        aE();
        var bZ = new a6("right");
        bZ.init()
    });
    var a6 = function (b5) {
        var b6, b2 = {},
            b7, b3 = this,
            b1 = false,
            bZ, b4, b0 = {
                x: 10,
                y: 66
            },
            bY = {
                x: 5,
                y: 1
            };
        this.move = function () {
            bZ = bZ + bY.x;
            b4 = b4 + bY.y;
            if (bZ < b0.x) {
                bZ = b0.x;
                bY.x = -bY.x
            } else {
                if (bZ > b2.dx) {
                    bZ = b2.dx;
                    bY.x = -bY.x
                }
            } if (b4 < b0.y) {
                b4 = b0.y;
                bY.y = -bY.y
            } else {
                if (b4 > b2.dy) {
                    b4 = b2.dy;
                    bY.y = -bY.y
                }
            }
            b7.css(b5, bZ + "px").css("top", b4 + "px")
        };
        this.init = function () {
            if (b1) {
                return
            }
            b1 = true;
            b7 = $(a6.htmlTemplate);
            $(window).on("resize", b3.resize);
            b7.css(b5, b0.x + "px").css({
                top: b0.y + "px"
            }).on("mouseenter", b3.stop).on("mouseleave", b3.resize).children("a.close").on("click", b3.hidden);
            $("body").append(b7);
            bZ = b0.x;
            b4 = b0.y;
            b3.resize()
        };
        this.destory = function () {
            b7.remove()
        };
        this.resize = function () {
            b2.dx = ($(window).width() - $(".content").width()) / 2 - b7.width();
            b2.dy = ($(window).height()) - b7.height();
            if (b2.dx <= (b0.x + Math.abs(bY.x)) || b2.dy <= (b0.y + Math.abs(bY.y))) {
                b3.stop()
            } else {
                b3.alive()
            }
        };
        this.show = function () {
            b7.show();
            b3.alive()
        };
        this.hidden = function () {
            b3.stop();
            b7.hide()
        };
        this.stop = function () {
            clearInterval(b6)
        };
        this.alive = function () {
            b3.stop();
            b6 = setInterval(b3.move, 200)
        }
    };
    a6.htmlTemplate = '<div class="fix-yh"><a href="javascript:void(0);" class="close" title="关闭">关闭</a></div>';

    function W() {
        if (rqChecked.length == 0) {
            if (train_tour_flag == "fc") {
                rqChecked.push($("#back_train_date").val())
            } else {
                rqChecked.push($("#train_date").val())
            }
        }
    }

    function bI() {
        if (ClickWho == "0X00") {
            $("#sf1").attr("disabled", "true");
            $("#sf1_label").addClass("color999");
            $("#sf2").attr("checked", "true");
            $("#query_ticket").removeClass().addClass("btn92s")
        } else {
            if (ClickWho == "00" || ClickWho == "ADULT") {
                $("#sf2").attr("disabled", "true");
                $("#sf2_label").addClass("color999");
                $("#query_ticket").removeClass().addClass("btn92s")
            } else {
                $("#query_ticket").removeClass().addClass("btn92s")
            }
        } if (isstudentDate) {
            $("#sf2").attr("disabled", "true");
            $("#sf2_label").addClass("color999");
            $("#query_ticket").removeClass().addClass("btn92s")
        }
    }

    function Z() {
        if (!isInitStationDiv) {
            d();
            isInitStationDiv = true
        }
        if (!isInitJsrenderTemplate) {
            ai();
            isInitJsrenderTemplate = true
        }
    }

    function aU() {
        $("#fromStationText").mouseover(Z);
        $("#toStationText").mouseover(Z);
        $("#dc").mouseover(Z);
        $("#wf").mouseover(Z);
        $("#dc_label").mouseover(Z);
        $("#wf_label").mouseover(Z);
        $("#train_date").mouseover(Z);
        $("#back_train_date").mouseover(Z);
        $("#date_range").mouseover(Z)
    }

    function ap(bY) {
        ax();
        var b5 = bp.length;
        if ($("#query_ticket").html() == "停止查询") {
            if (b5 > 0 && aA) {
                $("#auto_query").removeAttr("disabled");
                if ($("#dc").is(":checked") && train_tour_flag != "gc") {
                    $("#autoSubmit").removeAttr("disabled");
                    $("#partSubmit").removeAttr("disabled")
                }
                $("#query_ticket").html("查询");
                $("#query_ticket").unbind("click");
                bq();
                if (countDown) {
                    clearInterval(countDown)
                }
                $("#filterTicDiv").html("<strong><label for='filterTic' style='cursor: pointer;'>仅显示选定车次</label></strong>");
                if (!$("#autoSubmit").is(":checked")) {
                    clearInterval(aJ);
                    if (ccSelected.length > 0 || rqChecked.length > 0 || xbChecked.length > 0) {
                        myJpopup.startOrHiden();
                        if (train_tour_flag == "fc") {
                            var b6 = "成功查到" + $("#back_train_date").val() + "的" + bp[0]["queryLeftNewDTO"]["station_train_code"] + "次"
                        } else {
                            var b6 = "成功查到" + $("#train_date").val() + "的" + bp[0]["queryLeftNewDTO"]["station_train_code"] + "次"
                        } if (b5 == 1) {
                            b6 = b6 + "车。"
                        } else {
                            b6 = b6 + "等" + b5 + "趟车。"
                        }
                        $("#filterRes").html(b6)
                    }
                }
                jPlayer("play")
            } else {
                if (countDown) {
                    clearInterval(countDown)
                }
                var b4 = autoSearchTime / 1000;
                $("#filterTicDiv").html("<strong>离下次刷新时间<font class='colorA' style='font-size: 16px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + b4 + "</font>秒<strong>");
                countDown = window.setInterval(function () {
                    var b7 = "<strong>离下次刷新时间<font class='colorA' style='font-size: 16px;'>";
                    if (b4 == 0) {
                        b4 = autoSearchTime / 1000
                    }
                    b4 = b4 - 1;
                    if (b4 == 4) {
                        b7 = b7 + "&nbsp;&nbsp;&nbsp;&nbsp;"
                    }
                    if (b4 == 3) {
                        b7 = b7 + "&nbsp;&nbsp;&nbsp;"
                    }
                    if (b4 == 2) {
                        b7 = b7 + "&nbsp;&nbsp;"
                    }
                    if (b4 == 1) {
                        b7 = b7 + "&nbsp;"
                    }
                    b7 = b7 + b4;
                    b7 += "</font>秒<strong>";
                    $("#filterTicDiv").html(b7)
                }, 1000);
                $("#filterTic").hide()
            }
        }
        var b3 = new Array();
        b3.push('<tbody id="queryLeftTable">');
        var b0 = bB(bY);
        if (b0) {
            bY = bO(bY)
        }
        for (var bZ = 0; bZ < bY.length; bZ++) {
            b3.push('<tr id="ticket_');
            b3.push(bY[bZ].queryLeftNewDTO.train_no);
            b3.push('" class="');
            b3.push(bZ % 2 ? '">' : 'bgc">');
            b3.push('<td colspan="4" width="370">');
            b3.push('<div class="ticket-info clearfix" id="train_num_');
            b3.push(bZ);
            b3.push('">');
            b3.push('<div class="train" id="ticket_');
            b3.push(bY[bZ].queryLeftNewDTO.train_no);
            b3.push('_train">');
            var b2 = "";
            if (c(bY[bZ].queryLeftNewDTO.station_train_code)) {
                b2 = ' style="color:red;" '
            }
            b3.push("<div><a  " + b2 + ' title="点击查看停靠站信息" href="javascript:" id="');
            b3.push(bY[bZ].queryLeftNewDTO.train_no);
            b3.push("_");
            b3.push(bY[bZ].queryLeftNewDTO.from_station_telecode);
            b3.push("_");
            b3.push(bY[bZ].queryLeftNewDTO.to_station_telecode);
            b3.push('" class="number"  onclick="myStopStation.open(\'');
            b3.push(bZ);
            b3.push("','");
            b3.push(bY[bZ].queryLeftNewDTO.train_no);
            b3.push("','");
            b3.push(bY[bZ].queryLeftNewDTO.from_station_telecode);
            b3.push("','");
            b3.push(bY[bZ].queryLeftNewDTO.to_station_telecode);
            b3.push("','");
            b3.push(bY[bZ].queryLeftNewDTO.start_train_date);
            b3.push("','");
            b3.push(bY[bZ].queryLeftNewDTO.train_seat_feature);
            b3.push("');\">");
            b3.push(bY[bZ].queryLeftNewDTO.station_train_code);
            b3.push("</a>");
            if (bY[bZ].queryLeftNewDTO.is_support_card != 0) {
                b3.push(' <span class="i-card" title="可凭二代身份证直接进出站"></span>')
            }
            b3.push("</div>");
            b3.push('<span id="');
            b3.push(bY[bZ].queryLeftNewDTO.train_no);
            b3.push("_");
            b3.push(bY[bZ].queryLeftNewDTO.from_station_no);
            b3.push("_");
            b3.push(bY[bZ].queryLeftNewDTO.to_station_no);
            b3.push("_");
            b3.push(bY[bZ].queryLeftNewDTO.yp_info);
            b3.push("_");
            b3.push(bY[bZ].queryLeftNewDTO.seat_types);
            b3.push('" class="lookup" onclick="showTicketPrice(this)"><span style="display:none;">查看票价</span><b title="查看票价"></b></span>');
            b3.push("</div>");
            b3.push('<div class="cdz">');
            if (bY[bZ].queryLeftNewDTO.from_station_telecode != null && bY[bZ].queryLeftNewDTO.from_station_telecode == bY[bZ].queryLeftNewDTO.start_station_telecode) {
                b3.push('<strong class="start-s">');
                b3.push(bY[bZ].queryLeftNewDTO.from_station_name);
                b3.push("</strong>")
            } else {
                b3.push("<strong>");
                b3.push(bY[bZ].queryLeftNewDTO.from_station_name);
                b3.push("</strong>")
            } if (bY[bZ].queryLeftNewDTO.to_station_telecode != null && bY[bZ].queryLeftNewDTO.to_station_telecode == bY[bZ].queryLeftNewDTO.end_station_telecode) {
                b3.push('<strong class="end-s">');
                b3.push(bY[bZ].queryLeftNewDTO.to_station_name);
                b3.push("</strong>")
            } else {
                b3.push("<strong>");
                b3.push(bY[bZ].queryLeftNewDTO.to_station_name);
                b3.push("</strong>")
            }
            b3.push("</div>");
            b3.push('<div class="cds">');
            b3.push('<strong class="start-t">');
            b3.push(bY[bZ].queryLeftNewDTO.start_time);
            b3.push("</strong>");
            b3.push('<strong class="color999">');
            b3.push(bY[bZ].queryLeftNewDTO.arrive_time);
            b3.push("</strong>");
            b3.push("</div>");
            b3.push('<div  class="ls" ');
            b3.push('id="');
            b3.push(bY[bZ].queryLeftNewDTO.train_no);
            b3.push('_ls">');
            b3.push("<strong>");
            b3.push(bY[bZ].queryLeftNewDTO.lishi);
            b3.push("</strong>");
            b3.push("<span>");
            b3.push(changeArriveDate(bY[bZ].queryLeftNewDTO.start_time, bY[bZ].queryLeftNewDTO.lishi));
            b3.push("到达</span>");
            b3.push("</div>");
            b3.push("</div>");
            b3.push("</td>");
            bJ(b3, bY[bZ].queryLeftNewDTO.swz_num, "SWZ_", bY[bZ].queryLeftNewDTO.train_no, bY[bZ].queryLeftNewDTO.yp_ex, "91");
            bJ(b3, bY[bZ].queryLeftNewDTO.tz_num, "TZ_", bY[bZ].queryLeftNewDTO.train_no, bY[bZ].queryLeftNewDTO.yp_ex, "P1");
            bJ(b3, bY[bZ].queryLeftNewDTO.zy_num, "ZY_", bY[bZ].queryLeftNewDTO.train_no, bY[bZ].queryLeftNewDTO.yp_ex, "M1");
            bJ(b3, bY[bZ].queryLeftNewDTO.ze_num, "ZE_", bY[bZ].queryLeftNewDTO.train_no, bY[bZ].queryLeftNewDTO.yp_ex, "O1");
            bJ(b3, bY[bZ].queryLeftNewDTO.gr_num, "GR_", bY[bZ].queryLeftNewDTO.train_no, bY[bZ].queryLeftNewDTO.yp_ex, "61");
            bJ(b3, bY[bZ].queryLeftNewDTO.rw_num, "RW_", bY[bZ].queryLeftNewDTO.train_no, bY[bZ].queryLeftNewDTO.yp_ex, "41");
            bJ(b3, bY[bZ].queryLeftNewDTO.yw_num, "YW_", bY[bZ].queryLeftNewDTO.train_no, bY[bZ].queryLeftNewDTO.yp_ex, "31");
            bJ(b3, bY[bZ].queryLeftNewDTO.rz_num, "RZ_", bY[bZ].queryLeftNewDTO.train_no, bY[bZ].queryLeftNewDTO.yp_ex, "21");
            bJ(b3, bY[bZ].queryLeftNewDTO.yz_num, "YZ_", bY[bZ].queryLeftNewDTO.train_no, bY[bZ].queryLeftNewDTO.yp_ex, "11");
            bJ(b3, bY[bZ].queryLeftNewDTO.wz_num, "WZ_", bY[bZ].queryLeftNewDTO.train_no, bY[bZ].queryLeftNewDTO.yp_ex, "W1");
            bJ(b3, bY[bZ].queryLeftNewDTO.qt_num, "QT_", bY[bZ].queryLeftNewDTO.train_no, bY[bZ].queryLeftNewDTO.yp_ex, "");
            if ("Y" == bY[bZ].queryLeftNewDTO.canWebBuy) {
                b3.push(' <td align="center" width="80" class="no-br"><a href="javascript:" class="btn72" onclick="checkG1234(\'');
                b3.push(bY[bZ].secretStr);
                b3.push("','");
                b3.push(bY[bZ].queryLeftNewDTO.start_time);
                b3.push("','");
                b3.push(bY[bZ].queryLeftNewDTO.train_no);
                b3.push("','");
                b3.push(bY[bZ].queryLeftNewDTO.from_station_telecode);
                b3.push("','");
                b3.push(bY[bZ].queryLeftNewDTO.to_station_telecode);
                b3.push("')\">");
                b3.push(buttonText());
                b3.push("</a>");
                b3.push("</td>")
            } else {
                b3.push('<td align="center" width="80" class="no-br">');
                b3.push(bY[bZ].buttonTextInfo);
                b3.push("</td>")
            }
            b3.push("</tr>");
            b3.push('<tr datatran="' + bY[bZ].queryLeftNewDTO.station_train_code + '" id="price_');
            b3.push(bY[bZ].queryLeftNewDTO.train_no);
            b3.push('" style="display:none;"></tr>')
        }
        b3.push("</tbody>");
        $("#queryLeftTable").replaceWith(b3.join(""));
        if (b0) {
            for (var bZ = 0; bZ < bY.length; bZ++) {
                var b1 = bY[bZ];
                if (c(b1.queryLeftNewDTO.station_train_code)) {
                    showTicketPrice($("#SWZ_" + b1.queryLeftNewDTO.train_no)[0])
                }
            }
        }
    }

    function bO(bZ) {
        if (bZ && bZ.length > 0) {
            var b3 = [];
            var bY = [];
            for (var b0 = 0, b1 = bZ.length; b0 < b1; b0++) {
                var b2 = bZ[b0];
                if (c(b2.queryLeftNewDTO.station_train_code)) {
                    b3.push(b2)
                } else {
                    bY.push(b2)
                }
            }
            bZ = b3.concat(bY)
        }
        return bZ
    }

    function c(b0) {
        if (DW_TRAINS && DW_TRAINS.length) {
            for (var bY = 0, bZ = DW_TRAINS.length; bY < bZ; bY++) {
                if (b0 == DW_TRAINS[bY]) {
                    return true
                }
            }
        } else {
            return false
        }
        return false
    }

    function bB(bY) {
        if (bY && bY.length > 0) {
            if (DW_TRAINS && DW_TRAINS.length) {
                for (var b1 = 0, b3 = bY.length; b1 < b3; b1++) {
                    var b2 = bY[b1].queryLeftNewDTO.station_train_code;
                    for (var bZ = 0, b0 = DW_TRAINS.length; bZ < b0; bZ++) {
                        if (b2 == DW_TRAINS[bZ]) {
                            return true
                        }
                    }
                }
            }
        }
        return false
    }

    function bJ(b1, bZ, b6, b2, b0, b5) {
        b0 = b0.replace("F", "4").replace("A", "6");
        var b4 = b0 ? b0.indexOf(b5) : -1;
        var b3 = false;
        if (b4 > -1 && (b4 % 2) == 0) {
            b3 = true
        }
        if ("有" == bZ) {
            if (b6 == "SWZ_" || b6 == "TZ_") {
                b1.push('<td width="46" align="center" class="yes" onclick="showTicketPrice(this)"　style="cursor: pointer;" id="');
                b1.push(b6);
                b1.push(b2);
                b1.push('">');
                if (b3) {
                    b1.push('<div class="sale" title="本席别票价打折">' + bZ + '<span class="i-mark">折</span></div>')
                } else {
                    b1.push(bZ)
                }
                b1.push("</td>")
            } else {
                if (b6 == "ZY_" || b6 == "ZE_") {
                    b1.push('<td width="46" align="center" class="yes" style="cursor: pointer;" onclick="showTicketPrice(this)" id="');
                    b1.push(b6);
                    b1.push(b2);
                    b1.push('">');
                    if (b3) {
                        b1.push('<div class="sale" title="本席别票价打折">' + bZ + '<span class="i-mark">折</span></div>')
                    } else {
                        b1.push(bZ)
                    }
                    b1.push("</td>")
                } else {
                    b1.push('<td width="46" align="center" style="cursor: pointer;" class="yes" onclick="showTicketPrice(this)" id="');
                    b1.push(b6);
                    b1.push(b2);
                    b1.push('">');
                    if (b3) {
                        b1.push('<div class="sale" title="本席别票价打折">' + bZ + '<span class="i-mark">折</span></div>')
                    } else {
                        b1.push(bZ)
                    }
                    b1.push("</td>")
                }
            }
        } else {
            if (bZ == "无" || isNum(bZ) >= 0) {
                var bY = ' class="t-num" ';
                if (bZ == "无" || isNum(bZ) == 0) {
                    bY = ""
                }
                if (b6 == "SWZ_" || b6 == "TZ_" || b6 == "ZY_" || b6 == "ZE_") {
                    b1.push('<td width="46" align="center" style="cursor: pointer;" ' + bY + ' onclick="showTicketPrice(this)" id="');
                    b1.push(b6);
                    b1.push(b2);
                    b1.push('">');
                    b1.push("<div>");
                    if (b3) {
                        b1.push('<div class="sale" title="本席别票价打折">' + bZ + '<span class="i-mark">折</span></div>')
                    } else {
                        b1.push(bZ)
                    }
                    b1.push("</td>")
                } else {
                    b1.push('<td width="46" align="center" style="cursor: pointer;" ' + bY + ' onclick="showTicketPrice(this)" id="');
                    b1.push(b6);
                    b1.push(b2);
                    b1.push('">');
                    if (b3) {
                        b1.push('<div class="sale" title="本席别票价打折">' + bZ + '<span class="i-mark">折</span></div>')
                    } else {
                        b1.push(bZ)
                    }
                    b1.push("</td>")
                }
            } else {
                b1.push(' <td width="46" align="center" style="cursor: pointer;" onclick="showTicketPrice(this)"  id="');
                b1.push(b6);
                b1.push(b2);
                b1.push('">');
                b1.push(bZ);
                b1.push("</td>")
            }
        }
    }

    function j(bZ, bY) {
        ishaveCheckId = false;
        for (i = 0; i < bZ.length; i++) {
            if (bZ[i][0] == bY) {
                bZ[i][1] = $("#".concat($("#".concat(bY)).attr("for"))).is(":checked");
                ishaveCheckId = true
            }
        }
        if (!ishaveCheckId) {
            bZ[bZ.length] = [bY, true]
        }
    }

    function bs() {
        e(bi);
        e(a7);
        e(J)
    }

    function e(bY) {
        for (i = 0; i < bY.length; i++) {
            if (bY[i][1]) {
                $("#".concat(bY[i][0]).concat("_check")).attr("checked", true)
            }
        }
    }

    function A(bZ) {
        var bY = new Date();
        var b0 = bZ.split("-");
        bY.setFullYear(parseInt(b0[0]), parseInt(b0[1] - 1, 10), parseInt(b0[2], 10));
        if (b0.length >= 6) {
            bY.setHours(b0[3], b0[4], b0[5])
        }
        return bY
    }
    Date.prototype.format = function (bZ) {
        var b0 = {
            "M+": this.getMonth() + 1,
            "d+": this.getDate(),
            "h+": this.getHours(),
            "m+": this.getMinutes(),
            "s+": this.getSeconds(),
            "q+": Math.floor((this.getMonth() + 3) / 3),
            S: this.getMilliseconds()
        };
        if (/(y+)/.test(bZ)) {
            bZ = bZ.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length))
        }
        for (var bY in b0) {
            if (new RegExp("(" + bY + ")").test(bZ)) {
                bZ = bZ.replace(RegExp.$1, RegExp.$1.length == 1 ? b0[bY] : ("00" + b0[bY]).substr(("" + b0[bY]).length))
            }
        }
        return bZ
    };

    function aw(b0, bZ) {
        var bY = new Date(Date.parse(b0.replace(/-/g, "/")));
        bY.setDate(bY.getDate() + bZ);
        return L(bY)
    }

    function L(bZ) {
        var b0 = bZ.getFullYear();
        var b2 = bZ.getMonth() + 1;
        var b1 = bZ.getDate();
        var bY = b0 + "-" + b2 + "-" + b1;
        return bY
    }

    function bk() {
        var b0 = $("#train_date").val();
        var bZ = $("#back_train_date").val();
        var bY = false;
        if ($("#wf").is(":checked")) {
            if (A(b0) <= A(bZ)) {
                bY = true
            }
        } else {
            return true
        }
        return bY
    }

    function bQ() {
        var b1 = $.jc_getFromStation();
        if (b1) {
            var b0 = b1.split(",");
            if (b0 && b0.length == 2) {
                $("#fromStationText").val(b0[0]);
                $("#fromStation").val(b0[1])
            }
        }
        var bZ = $.jc_getToStation();
        if (bZ) {
            var b0 = bZ.split(",");
            if (b0 && b0.length == 2) {
                $("#toStationText").val(b0[0]);
                $("#toStation").val(b0[1])
            }
        }
        var b2 = [];
        b2 = stu_buy_date.split("&");
        var bY = $.jc_getFromDate();
        if (bY) {
            if (bY >= b2[0] && bY <= b2[1]) {
                $("#train_date").val(bY)
            }
        }
        var b3 = $.jc_getWfOrDc();
        if (b3 && "wf" == b3) {
            $("#wf").click();
            var b4 = $.jc_getToDate();
            if (b4) {
                if (b4 >= b2[0] && b4 <= b2[1]) {
                    $("#back_train_date").val(b4)
                }
            }
        } else {
            $("#dc").click()
        }
    }

    function aK() {
        $("#train_stop").on("mouseover", function (bY) {
            if (checkHover(bY, this)) {
                bF = 1
            }
        }).on("mouseleave", function () {
            bF = 0;
            $("#train_stop").hide();
            $("#train_table_").html("")
        })
    }

    function f() {
        fromStation = from_station;
        fromStationName = from_station_name;
        toStation = to_station;
        toStationName = to_station_name;
        trainDate = trainDate;
        backTrainDate = backTrainDate;
        bi = new Array();
        a7 = new Array();
        J = new Array()
    }

    function r() {
        if ($("#sf1").is(":checked")) {
            isOther = true;
            if (other_control < dataNumber) {
                for (var bY = other_control + 1; bY <= dataNumber; bY++) {
                    $("#date-list>li:nth-child(" + bY + ")").hide()
                }
            } else {
                for (var bY = 1; bY <= dataNumber; bY++) {
                    $("#date-list>li:nth-child(" + bY + ")").show()
                }
            }
        } else {
            isOther = false;
            if (stu_control < dataNumber) {
                for (var bY = stu_control + 1; bY <= dataNumber; bY++) {
                    $("#date-list>li:nth-child(" + bY + ")").hide()
                }
            } else {
                for (var bY = 1; bY <= dataNumber; bY++) {
                    $("#date-list>li:nth-child(" + bY + ")").show()
                }
            }
        }
    }

    function n() {
        $("#fromStation").val(fromStation);
        $("#fromStationText").val(fromStationName);
        $("#toStation").val(toStation);
        $("#toStationText").val(toStationName);
        $("#train_date").val(trainDate);
        if (isInMaintenanceHours) {
            $("#autoSubmit").prop("checked", false);
            $("#autoSubmit").attr("disabled", true);
            $("#autoSubmit").siblings("label").css("color", "#999");
            $("#autoSubmitTxt").attr("title", "系统维护时间下不允许自动提交");
            $("#partSubmit").prop("checked", false);
            $("#partSubmit").attr("disabled", true);
            $("#partSubmit").siblings("label").css("color", "#999");
            $("#partSubmitTxt").attr("title", "系统维护时间下不允许自动提交");
            $("#auto_query").prop("checked", false);
            $("#auto_query").attr("disabled", true);
            $("#auto_query").siblings("label").css("color", "#999");
            $("#autoQueryTxt").attr("title", "系统维护时间下不允许自动查询")
        }
        if (backTrainDate != null && backTrainDate != "") {
            $("#back_train_date").val(backTrainDate)
        }
        if ($("#fromStationText").val() == "") {
            $("#fromStationText").val("简拼/全拼/汉字")
        }
        if ($("#toStationText").val() == "") {
            $("#toStationText").val("简拼/全拼/汉字")
        }
        if (page_show_flag == null) {
            bQ()
        } else {
            if (page_show_flag == "index") {
                a5()
            } else {
                if (page_show_flag == "preStep") {
                    bL()
                } else {
                    if (page_show_flag == "fcInit") {
                        t();
                        $("#autoSubmit").attr("disabled", true);
                        $("#autoSubmit").siblings("label").css("color", "#999");
                        $("#partSubmit").attr("disabled", true);
                        $("#partSubmit").siblings("label").css("color", "#999")
                    } else {
                        if (page_show_flag == "gcInit") {
                            a8();
                            $("#autoSubmit").attr("disabled", true);
                            $("#autoSubmit").siblings("label").css("color", "#999");
                            $("#partSubmit").attr("disabled", true);
                            $("#partSubmit").siblings("label").css("color", "#999")
                        }
                    }
                }
            }
        }
    }

    function a5() {
        if (tour_flag == "wf") {
            $("#wf").click()
        } else {
            if (tour_flag == "dc") {
                $("#dc").click()
            }
        } if (purposeCodeFromIndex == "0X00") {
            $("#sf2").click()
        } else {
            if (purposeCodeFromIndex == "ADULT") {
                $("#sf1").click()
            }
        }
        var bY = [];
        $("#date_range>ul>li").each(function () {
            var bZ = $(this).children("span:first-child").html();
            bY.push(bZ)
        });
        $("#query_ticket").click()
    }

    function bL() {
        $("#fromStationText").removeClass().addClass("inp_selected");
        $("#toStationText").removeClass().addClass("inp_selected");
        if (train_tour_flag == "dc") {
            ag(trainDate);
            $("#dc").click()
        }
        if (train_tour_flag == "wc") {
            ag(trainDate);
            $("#wf").click()
        }
        if (train_tour_flag == "fc") {
            ag(backTrainDate);
            $("#wf").click();
            $("#wf").attr("disabled", "true");
            $("#dc").attr("disabled", "true");
            $("#change_station").removeClass().addClass("i-change i-change2");
            $("#change_station").attr("style", "");
            $("#fromStationText").attr("title", "返程时不得变更出发地或不能变更到达地");
            $("#toStationText").attr("title", "返程时不得变更出发地或不能变更到达地");
            $("#toStationText").unbind("focus").unbind("click").attr("readonly", "true");
            $("#fromStationText").unbind("focus").unbind("click").attr("readonly", "true");
            $("#dfc>ul>li:nth-child(2)").children("label:first").removeClass().addClass("color999");
            $("#dfc>ul>li:nth-child(1)").children("label:first").removeClass().addClass("color999");
            $("#place_area>ul>li:nth-child(1)").addClass("no-change");
            $("#place_area>ul>li:nth-child(3)").addClass("no-change");
            $("#place_area>ul>li:nth-child(4)").addClass("no-change");
            $("#fromStationText").removeClass().addClass("inp-txt");
            $("#toStationText").removeClass().addClass("inp-txt");
            $("#change_station").unbind();
            $("#train_date").val(trainDate);
            $("#train_date").attr("readonly", "true");
            $("#train_date").removeClass().addClass("inp-txt");
            $("#train_date").unbind("click");
            $("#date_icon_1").unbind("click");
            $("#date_area>ul>li:nth-child(1)>span>label").addClass("color999");
            $("#back_train_date").val(backTrainDate);
            $("#back_train_date").removeAttr("disabled");
            $("#date_area>ul>li:nth-child(2)>span>label").removeClass("color999");
            $("#back_train_date").removeClass().addClass("inp_selected");
            $("#autoSubmit").attr("disabled", true);
            $("#autoSubmit").siblings("label").css("color", "#999");
            $("#partSubmit").attr("disabled", true);
            $("#partSubmit").siblings("label").css("color", "#999")
        }
        if (train_tour_flag == "gc") {
            ag(trainDate);
            a8();
            $("#autoSubmit").attr("disabled", true);
            $("#autoSubmit").siblings("label").css("color", "#999");
            $("#partSubmit").attr("disabled", true);
            $("#partSubmit").siblings("label").css("color", "#999")
        }
    }

    function ag(b0) {
        for (var bY = 1; bY <= 20; bY++) {
            var bZ = $("#date_range>ul>li:nth-child(" + bY + ")").children("span:first-child").text();
            bZ = "2013-" + bZ;
            if (b0 == bZ) {
                $("#date_range>ul>li").removeClass("sel");
                $("#date_range>ul>li").removeAttr("alt");
                $("#date_range>ul>li:nth-child(" + bY + ")").addClass("sel");
                $("#date_range>ul>li:nth-child(" + bY + ")").attr("alt", "show");
                $("#date_range>ul>li:nth-child(20)").addClass("end");
                $("#date_range>ul>li:nth-child(" + bY + ")").children("span:first-child").removeClass();
                $("#date_range>ul>li:nth-child(" + bY + ")").children("span:last-child").removeClass();
                $("#date_range>ul>li:nth-child(" + bY + ")").children("span:first-child").addClass("hide");
                $("#date_range>ul>li:nth-child(1)").children().addClass("first");
                bx = $("#date_range>ul>li:nth-child(" + bY + ")").children("span:first-child").text();
                break
            }
        }
    }

    function a8() {
        $("#fromStationText").attr("title", "改签时不得变更出发地或不能变更到达地");
        $("#dc").click();
        $("#wf").attr("disabled", "true");
        $("#dc").attr("disabled", "true");
        $("#place_area>ul>li:nth-child(1)").addClass("no-change");
        $("#place_area>ul>li:nth-child(3)").addClass("no-change");
        $("#place_area>ul>li:nth-child(5)").addClass("no-change");
        $("#dfc>ul>li:nth-child(1)").children("label:first").removeClass().addClass("color999");
        $("#dfc>ul>li:nth-child(2)").children("label:first").removeClass().addClass("color999");
        $("#fromStationText").unbind("focus").unbind("click").attr("readonly", "true");
        if ("Y" != canChangeToStation) {
            $("#toStationText").unbind("focus").unbind("click").attr("readonly", "true");
            $("#toStationText").removeClass().addClass("inp-txt");
            $("#toStationText_label").addClass("color999")
        }
        $("#fromStationText").removeClass().addClass("inp-txt");
        $("#fromStationText_label").addClass("color999");
        $("#change_station").unbind();
        $("#change_station").removeClass().addClass("i-change i-change2");
        $("#change_station").attr("style", "")
    }

    function t() {
        $("#fromStationText").attr("title", "订返程票时不得变更出发地或不能变更到达地");
        $("#toStationText").attr("title", "订返程票时不得变更出发地或不能变更到达地");
        ag(backTrainDate);
        $("#wf").click();
        $("#dc").attr("disabled", "true");
        $("#wf").attr("disabled", "true");
        $("#place_area>ul>li:nth-child(1)").addClass("no-change");
        $("#place_area>ul>li:nth-child(3)").addClass("no-change");
        $("#place_area>ul>li:nth-child(4)").addClass("no-change");
        $("#dfc>ul>li:nth-child(1)").children("label:first").removeClass().addClass("color999");
        $("#dfc>ul>li:nth-child(2)").children("label:first").removeClass().addClass("color999");
        $("#train_date").attr("readonly", "true");
        $("#train_date").addClass("color999");
        $("#train_date").attr("disabled", true);
        $("#train_date").unbind("click");
        $("#date_icon_1").unbind("click");
        $("#date_area>ul>li:nth-child(1)>span>label").addClass("color999");
        $("#back_train_date").removeAttr("disabled");
        $("#date_area>ul>li:nth-child(2)>span>label").removeClass("color999");
        $("#train_date").removeClass().addClass("inp-txt");
        $("#back_train_date").removeClass().addClass("inp_selected");
        $("#fromStationText").unbind("focus").unbind("unfocus").unbind("click").attr("readonly", "true");
        $("#toStationText").unbind("focus").unbind("unfocus").unbind("click").attr("readonly", "true");
        $("#fromStationText").removeClass().addClass("inp-txt");
        $("#toStationText").removeClass().addClass("inp-txt");
        $("#change_station").unbind();
        $("#change_station").removeClass().addClass("i-change i-change2");
        $("#change_station").attr("style", "")
    }

    function R() {
        initPageTitle(1);
        $("#train_type_btn_all").css("cursor", "pointer");
        $("#start_time_btn_all").css("cursor", "pointer");
        $("#arrive_time_btn_all").css("cursor", "pointer");
        $("#seat_type_btn_all").css("cursor", "pointer");
        $("#from_station_name_all").css("cursor", "pointer");
        $("#to_station_name_all").css("cursor", "pointer");
        $("#change_station").css("cursor", "pointer");
        $("#show_more").css("cursor", "pointer");
        $("#date_normal").css("cursor", "pointer");
        $("#lookup").css("cursor", "pointer");
        $("#s_time").css("cursor", "pointer");
        $("#r_time").css("cursor", "pointer");
        $("#l_s").css("cursor", "pointer");
        $("#other_span_starttime").css("cursor", "pointer");
        $("#other_span_endtime").css("cursor", "pointer");
        $("#other_span_lishi").css("cursor", "pointer");
        $("#date_range>ul>li").children("span:nth-child(1)").css("cursor", "pointer");
        $("#cc_seat_type_btn_all>ul>li").hide();
        $("#train_date").removeClass().addClass("inp_selected");
        if ($("#fromStationText").val() != "" && $("#fromStationText").val() != "简拼/全拼/汉字" || $("#toStationText").val() != "" && $("#toStationText").val() != "简拼/全拼/汉字") {
            $("#fromStationText").removeClass().addClass("inp_selected");
            $("#toStationText").removeClass().addClass("inp_selected")
        }
        var bY = stu_start_train_date.split("&");
        var bZ = stu_end_tain_date.split("&")
    }

    function bN(bZ) {
        var bY = ("00" + (bZ.getMonth() + 1)).slice(-2) + "-";
        bY += ("00" + bZ.getDate()).slice(-2) + " 00:00:00";
        return bY
    }

    function w() {
        $("#dc").click(function () {
            $("#wf").attr("checked", false);
            $("#dc").attr("checked", "true");
            $("#place_area>ul>li:nth-child(5)").addClass("no-change");
            $("#back_train_date").removeClass().addClass("inp-txt");
            $("#back_train_date").attr("disabled", true)
        });
        $("#wf").click(function () {
            $("#dc").attr("checked", false);
            $("#wf").attr("checked", true);
            $("#back_train_date").removeAttr("disabled");
            $("#place_area>ul>li:nth-child(5)").removeClass();
            $("#train_date").removeClass().addClass("inp_selected");
            $("#back_train_date").removeClass().addClass("inp_selected");
            isbigdate = bk();
            if (!isbigdate) {
                train = $("#train_date").val();
                $("#back_train_date").val(train)
            }
            var bY = $("#train_date").val()
        })
    }

    function aO() {
        $("#avail_ticket").click(function () {
            $("#filterTic").attr("checked", false);
            au()
        });
        $("#train_type_btn_all").click(function () {
            var bY = true;
            $("#sear-sel-bd input[name='cc_type']").each(function () {
                if (!this.checked) {
                    bY = false
                }
            });
            if (bY) {
                $("#sear-sel-bd input[name='cc_type']").each(function () {
                    this.checked = false
                });
                $("#train_type_btn_all").removeClass().addClass("btn-all")
            } else {
                $("#sear-sel-bd input[name='cc_type']").each(function () {
                    if (!this.checked) {
                        this.checked = true
                    }
                });
                $("#train_type_btn_all").removeClass().addClass("btn-all")
            }
            au()
        });
        $("#start_time_btn_all").click(function () {
            var bY = true;
            $("#sear-sel-bd input[name='cc_start_time']").each(function () {
                if (!this.checked) {
                    bY = false
                }
            });
            if (bY) {
                $("#sear-sel-bd input[name='cc_start_time']").each(function () {
                    this.checked = false
                });
                $("#start_time_btn_all").removeClass().addClass("btn-all")
            } else {
                $("#sear-sel-bd input[name='cc_start_time']").each(function () {
                    if (!this.checked) {
                        this.checked = true
                    }
                });
                $("#start_time_btn_all").removeClass().addClass("btn-all")
            }
            au()
        });
        $("#from_station_name_all").click(function () {
            var bY = true;
            $("#sear-sel-bd input[name='cc_from_station']").each(function () {
                if (!this.checked) {
                    bY = false
                }
            });
            if (bY) {
                $("#sear-sel-bd input[name='cc_from_station']").each(function () {
                    this.checked = false;
                    j(bi, "cc_from_station_" + $(this).val())
                });
                $("#from_station_name_all").removeClass().addClass("btn-all")
            } else {
                $("#sear-sel-bd input[name='cc_from_station']").each(function () {
                    if (!this.checked) {
                        this.checked = true;
                        j(bi, "cc_from_station_" + $(this).val())
                    }
                });
                $("#from_station_name_all").removeClass().addClass("btn-all")
            }
            au()
        });
        $("#to_station_name_all").click(function () {
            var bY = true;
            $("#sear-sel-bd input[name='cc_to_station']").each(function () {
                if (!this.checked) {
                    bY = false
                }
            });
            if (bY) {
                $("#sear-sel-bd input[name='cc_to_station']").each(function () {
                    this.checked = false;
                    j(a7, "cc_to_station_" + $(this).val())
                });
                $("#to_station_name_all").removeClass().addClass("btn-all")
            } else {
                $("#sear-sel-bd input[name='cc_to_station']").each(function () {
                    if (!this.checked) {
                        this.checked = true;
                        j(a7, "cc_to_station_" + $(this).val())
                    }
                });
                $("#to_station_name_all").removeClass().addClass("btn-all")
            }
            au()
        })
    }

    function bz() {
        $("#change_station").bind("click", function () {
            var b2 = $("#fromStationText").val();
            var b4 = $("#fromStation").val();
            var b3 = $("#toStationText").val();
            var bY = $("#toStation").val();
            if ((b2 != "" && b2 != "简拼/全拼/汉字") && (b3 != "" && b3 != "简拼/全拼/汉字")) {
                $("#fromStationText").val(b3);
                $("#toStationText").val(b2);
                $("#fromStation").val(bY);
                $("#toStation").val(b4);
                $("#fromStationText").removeClass().addClass("inp_selected");
                $("#toStationText").removeClass().addClass("inp_selected")
            } else {
                aV.checkForm();
                aV.hideErrors();
                var b1 = aV.errorList;
                for (var b0 = 0; b0 < b1.length; b0++) {
                    var bZ = b1[b0];
                    $(bZ.element).next().addClass("error")
                }
                aV.checkForm()
            }
            br()
        })
    }

    function br() {
        if ($("#fromStationText").val() == "简拼/全拼/汉字") {
            $.stationFor12306.from_to_station_class_gray($("#fromStationText"))
        } else {
            $.stationFor12306.from_to_station_class_plain($("#fromStationText"))
        } if ($("#toStationText").val() == "简拼/全拼/汉字") {
            $.stationFor12306.from_to_station_class_gray($("#toStationText"))
        } else {
            $.stationFor12306.from_to_station_class_plain($("#toStationText"))
        }
    }

    function bh() {
        $("#show_more").click(function () {
            var bY = $(this);
            if (bY.hasClass("down")) {
                aj();
                bY.attr("class", "up")
            } else {
                document.getElementById("sear-sel-bd").style.height = "17px";
                bY.attr("class", "down");
                bY.parent().css("top", "59px")
            }
        })
    }

    function m() {
        if ($("#sear-sel-bd").height() != 17) {
            aj()
        }
    }

    function aj() {
        var b0 = "17px";
        var b2 = 179;
        var b1 = 28;
        var bY = $("#sear-sel-bd input[name='cc_from_station']").length;
        var b3 = $("#sear-sel-bd input[name='cc_to_station']").length;
        var bZ = $("#sear-sel-bd input[name='cc_seat_type']").length;
        if (bY > 7 && bY <= 14) {
            b0 = (b2 + b1) + "px"
        } else {
            if (b3 > 7 && bY <= 14) {
                b0 = (b2 + b1 * 2) + "px"
            } else {
                if (bZ > 7) {
                    b0 = (b2 + b1) + "px"
                } else {
                    b0 = b2 + "px"
                }
            }
        }
        document.getElementById("sear-sel-bd").style.height = b0;
        $("#show_more").parent().css("top", "221px")
    }

    function d() {
        if (train_tour_flag == "fc" || (train_tour_flag == "gc" && canChangeToStation != "Y")) {
            return
        }
        var bY = ["fromStation", "toStation"];
        if (canChangeToStation == "Y") {
            bY = ["toStation"]
        }
        $.stationFor12306.init(bY, {
            _init_input: "简拼/全拼/汉字",
            _top_4_initInput: "简拼/全拼/汉字或↑↓",
            _unselected_class: "inpt_unselected",
            _selected_class: "inp_selected",
            confirmCallBack: function (bZ, b0) {
                bZ.removeClass("error");
                if (bZ.attr("id") == "fromStationText") {
                    if (ccSelected.length > 0) {
                        if (bZ.val() != bv) {
                            $("#prior_train span:gt(0)").remove();
                            $("#inp-train").css("color", "#999");
                            $("#inp-train").val("  请输入");
                            ccSelected = [];
                            $("#prior_seat span:gt(0)").remove();
                            $("#seat-list input").prop("checked", false);
                            xbChecked = []
                        }
                    }
                    bv = bZ.val()
                }
                if (bZ.attr("id") == "toStationText") {
                    if (ccSelected.length > 0) {
                        if (bZ.val() != bK) {
                            $("#prior_train span:gt(0)").remove();
                            $("#inp-train").css("color", "#999");
                            $("#inp-train").val("  请输入");
                            ccSelected = [];
                            $("#prior_seat span:gt(0)").remove();
                            $("#seat-list input").prop("checked", false);
                            xbChecked = []
                        }
                    }
                    bK = bZ.val()
                }
            }
        });
        $("#fromStation_icon_image").css("cursor", "pointer");
        $("#fromStationText_label").click(function () {
            $("#fromStationText").focus()
        });
        $("#fromStation_icon_image").click(function () {
            $("#fromStationText").focus()
        });
        $("#toStation_icon_image").css("cursor", "pointer");
        $("#toStationText_label").click(function () {
            $("#toStationText").focus()
        });
        $("#toStation_icon_image").click(function () {
            $("#toStationText").focus()
        })
    }

    function bW() {
        aV = $("#queryLeftForm").validate({
            rules: {
                "leftTicketDTO.from_station": {
                    required: true
                },
                "leftTicketDTO.to_station": {
                    required: true
                },
                "leftTicketDTO.train_date": {
                    required: true
                },
                back_train_date: {
                    required: true
                }
            },
            ignore: "",
            onsubmit: false,
            onfocusout: function () {}, onkeyup: function () {}, onclick: function () {}, highlight: function () {}, unhighlight: function () {}
        });
        bq()
    }

    function b(bY) {
        dhtmlx.alert({
            title: "提示",
            ok: messages["button.ok"],
            text: bY,
            type: "alert-error",
            callback: function () {}
        })
    }

    function bo(bZ, b5) {
        var bY = aV.checkForm();
        aV.hideErrors();
        if (bY) {
            var b4 = "";
            if ($.trim($("#fromStation").val()) == $.trim($("#toStation").val()) || $.trim($("#fromStationText").val()) == $.trim($("#toStationText").val())) {
                b4 = "出发地和目的地不能相同";
                b(b4);
                return false
            }
            if (!bk()) {
                b4 = "返回日期不得早于出发日期";
                b(b4);
                return false
            }
            var b2 = [];
            if (b5) {
                b2 = stu_buy_date.split("&")
            } else {
                b2 = other_buy_date.split("&")
            } if (b2.length > 0) {
                if (bZ < b2[0] || bZ > b2[1]) {
                    b4 = "您选择的日期不在预售期范围内！";
                    b(b4);
                    return false
                }
            }
        } else {
            var b3 = aV.errorList;
            for (var b1 = 0; b1 < b3.length; b1++) {
                var b0 = b3[b1];
                $(b0.element).next().addClass("error")
            }
            return false
        }
        bP();
        return true
    }

    function bP() {
        $.jc_setFromStation($("#fromStationText").val(), $("#fromStation").val());
        $.jc_setToStation($("#toStationText").val(), $("#toStation").val());
        $.jc_setFromDate($("#train_date").val());
        $.jc_setToDate($("#back_train_date").val());
        $.jc_setWfOrDc($("#wf").is(":checked") ? "wf" : "dc")
    }

    function bq() {
        $("#query_ticket").unbind("click").click(function (b2) {
            if ($jpopup.isShow()) {
                $jpopup.quickHide()
            }
            if (myStopStation) {
                myStopStation.close()
            }
            if ($("#auto_query").is(":checked")) {
                var b1 = $.trim($("#inp-train").val()).toUpperCase();
                if (b1.length != 0 && b1 != "请输入") {
                    dhtmlx.alert({
                        title: "输入车次",
                        ok: "确定",
                        text: "您输入的优先车次未添加，请点击车次输入框后的添加按钮，或者取消车次输入框中的内容！",
                        type: "alert-error",
                        callback: function () {
                            ccInputSelected = true;
                            $("#inp-train").select()
                        }
                    });
                    return
                }
            }
            Z();
            if (document.getElementById("autoSubmit").checked) {
                if (passengerChecked.length == 0) {
                    dhtmlx.alert({
                        title: "选择乘车人",
                        ok: "确定",
                        text: "请选择乘车人",
                        type: "alert-error",
                        callback: function () {
                            return
                        }
                    });
                    return
                }
            }
            v = bV();
            var b3 = v == "0X00" ? true : false;
            var bZ = train_tour_flag == "fc" ? $.trim($("#back_train_date").val()) : $.trim($("#train_date").val());
            var bY = bo(bZ, b3);
            if (!bY) {
                return
            }
            var b0 = {
                "leftTicketDTO.train_date": bZ,
                "leftTicketDTO.from_station": $("#fromStation").val(),
                "leftTicketDTO.to_station": $("#toStation").val(),
                purpose_codes: v
            };
            aE();
            aa(b0)
        })
    }
    var aZ = function () {
        if ($("#filterTic").is(":checked")) {
            $("#avail_ticket").attr("checked", false);
            ax();
            if (bp.length != 0 && bp.length < aS.length) {
                $("#trainum").html(bp.length);
                ap(bp)
            }
        } else {
            bu = aW();
            if (bp.length != 0 && bp.length < bu.length) {
                $("#trainum").html(bu.length);
                ap(bu)
            }
        }
    };

    function aa(bY) {
        $("#cc_seat_type_btn_all>ul>li").css("display", "none");
        if ($("#auto_query").is(":checked")) {
            $("#query_ticket").html("停止查询");
            $("#auto_query").attr("disabled", "true");
            $("#autoSubmit").attr("disabled", "true");
            $("#partSubmit").attr("disabled", "true");
            $("#query_ticket").unbind("click");
            $("#query_ticket").bind("click", function () {
                $("#filterTic").hide();
                clearInterval(aJ);
                if (countDown) {
                    clearInterval(countDown)
                }
                $("#filterTicDiv").html("");
                $("#query_ticket").unbind("click");
                $("#query_ticket").html("查询");
                if ($("#dc").is(":checked") && train_tour_flag != "gc") {
                    $("#autoSubmit").removeAttr("disabled");
                    $("#partSubmit").removeAttr("disabled")
                }
                $("#auto_query").removeAttr("disabled");
                bq()
            })
        } else {
            if (countDown) {
                clearInterval(countDown)
            }
            $("#filterTicDiv").html("");
            bt()
        }
        var bZ = dhtmlx.modalbox({
            targSrc: '<div><img src="' + ctx + 'resources/images/loading.gif"></img></div>',
            callback: function () {}
        });
        if ($jpopup.isShow()) {
            $jpopup.quickHide()
        }
        $("#queryLeftTable").html("");
        $("#sear-result").hide();
        if (aJ) {
            clearInterval(aJ)
        }
        bD(bY);
        $.ajax({
            type: "get",
            isTakeParam: false,
            beforeSend: function (b0) {
                b0.setRequestHeader("If-Modified-Since", "0");
                b0.setRequestHeader("Cache-Control", "no-cache")
            }, url: ctx + CLeftTicketUrl,
            data: bY,
            timeout: 10000,
            error: function (b0, b2, b1) {
                dhtmlx.modalbox.hide(bZ);
                if ("timeout" == b2 || "No Transport" == b2 || "abort" == b2) {
                    if ($("#auto_query").is(":checked")) {
                        aa(bY)
                    }
                }
            }, success: function (b2) {
                dhtmlx.modalbox.hide(bZ);
                if (b2.status) {
                    if (b2.data == null || b2.data.length == 0) {
                        $("#sear-sel").hide();
                        $("#sear-result").hide();
                        $("#t-list").hide();
                        $("#no_filter_ticket_fromstation").html($("#fromStationText").val());
                        $("#no_filter_ticket_tostation").html($("#toStationText").val());
                        $("#no_filter_ticket_2").show();
                        $(".content").css("min-height", "344px");
                        return
                    }
                    if (train_tour_flag == "gc" && "Y" == isDwTicketResign) {
                        var b7 = [];
                        for (var b3 = 0, b8 = b2.data.length; b3 < b8; b3++) {
                            var b1 = b2.data[b3].queryLeftNewDTO;
                            var b5 = b1.station_train_code;
                            b5 = b5.substring(0, 1);
                            if ("G" == b5 || "D" == b5) {
                                b7.push(b2.data[b3])
                            }
                        }
                        b2.data = b7
                    }
                    if ($("#DW_SHOW_STR")[0]) {
                        $("#DW_SHOW_STR").remove()
                    }
                    $("#sear-sel").show();
                    $("#sear-result").show();
                    $("#t-list").show();
                    $("#no_filter_ticket_2").hide();
                    $("#no_filter_ticket").hide();
                    var b0 = "";
                    if (train_tour_flag != null && train_tour_flag == "fc") {
                        var b9 = "<strong>".concat($("#fromStationText").val()).concat(" --> ").concat($("#toStationText").val()).concat("（").concat(at($("#back_train_date").val())).concat('）</strong>共计<strong id="trainum">').concat(b2.data.length).concat("</strong>个车次");
                        if (bB(b2.data)) {
                            b0 = "<p class='ad-gt' id='DW_SHOW_STR' data='1'>高铁动卧 夕发朝至 风雨无阻 省时省钱</p>"
                        }
                        if ($("#auto_query").is(":checked")) {
                            var b6 = "";
                            for (var b4 = 0; b4 < 25; b4++) {
                                b6 = b6 + "&nbsp;"
                            }
                            b9 = b9.concat(b6 + "<input type='checkbox' class='check' id='filterTic' /><div id='filterTicDiv' style='display:inline'><strong><label for='filterTic' style='cursor: pointer;'>仅查看刷到车次</label></strong></div>")
                        }
                        $("#sear-result>p").html(b9);
                        if ($("#auto_query").is(":checked")) {
                            $("#filterTic").bind("click", aZ)
                        }
                    } else {
                        var b9 = "<strong>".concat($("#fromStationText").val()).concat(" --> ").concat($("#toStationText").val()).concat("（").concat(at($("#train_date").val())).concat('）</strong>共计<strong id="trainum">').concat(b2.data.length).concat("</strong>个车次");
                        if (bB(b2.data)) {
                            b0 = "<p class='ad-gt' id='DW_SHOW_STR' data='1'>高铁动卧 夕发朝至 风雨无阻 省时省钱</p>"
                        }
                        if ($("#auto_query").is(":checked")) {
                            var b6 = "";
                            for (var b4 = 0; b4 < 25; b4++) {
                                b6 = b6 + "&nbsp;"
                            }
                            b9 = b9.concat(b6 + "<input type='checkbox' class='check' id='filterTic' /><div id='filterTicDiv' style='display:inline'><strong><label for='filterTic' style='cursor: pointer;'>仅查看刷到车次</label></strong></div>")
                        }
                        $("#sear-result>p").html(b9);
                        if ($("#auto_query").is(":checked")) {
                            $("#filterTic").bind("click", aZ)
                        }
                    } if (!$("#DW_SHOW_STR")[0]) {
                        $("#sear-result>p").after(b0)
                    }
                    if (dwTranTimeStr) {
                        clearInterval(dwTranTimeStr)
                    }
                    if ($("#DW_SHOW_STR")[0]) {
                        dwTranTimeStr = window.setInterval(function () {
                            if ($("#DW_SHOW_STR").attr("data") == "1") {
                                $("#DW_SHOW_STR").attr("data", "2").html("夜行两千公里 最低不足千元")
                            } else {
                                $("#DW_SHOW_STR").attr("data", "1").html("高铁动卧 夕发朝至 风雨无阻 省时省钱")
                            }
                        }, 1300)
                    }
                    aS = b2.data;
                    a4(aS);
                    m();
                    bm(aS);
                    bs();
                    H()
                } else {
                    if (b2 && b2.c_url) {
                        if ($("#auto_query").is(":checked")) {
                            aa(bY)
                        }
                    }
                }
            }
        });
        aI()
    }

    function U() {
        dataNumber = other_control > stu_control ? other_control : stu_control;
        for (var bY = endShow + 1; bY <= dataNumber; bY++) {
            $("#date_range>ul>li:nth-child(" + bY + ")").hide()
        }
        var bZ;
        $("#date_range>ul>li").each(function (b3) {
            var b1 = fullDateArr[b3];
            var b0 = new Date(Date.parse(b1.replace(/-/g, "/")));
            var b2 = $("#date_range>ul>li:nth-child(" + (b3 + 1) + ")>span[class=hide]").text().substring(0, 5) + a2(b0);
            $("#date_range>ul>li:nth-child(" + (b3 + 1) + ")>span[class=hide]").text(b2);
            bZ = $(this).children("span:first-child").html();
            change_dates_arr.push(bZ)
        });
        if (index_train_date == null) {
            $("#date_range>ul>li:nth-child(1)").addClass("sel");
            $("#date_range>ul>li:nth-child(1)").attr("alt", "show");
            $("#date_range>ul>li:nth-child(20)").addClass("end");
            $("#date_range>ul>li:nth-child(1)").children("span:first-child").removeClass();
            $("#date_range>ul>li:nth-child(1)").children("span:last-child").removeClass();
            $("#date_range>ul>li:nth-child(1)").children().addClass("first");
            $("#date_range>ul>li:nth-child(1)").children("span:first-child").addClass("hide");
            bx = $("#date_range>ul>li:nth-child(1)").children("span:first-child").text()
        }
        a0()
    }

    function a2(bZ) {
        var b2 = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"];
        var b1 = 0;
        for (var b0 = 0; b0 < b2.length; b0++) {
            if (bZ.toString().indexOf(b2[b0]) > -1) {
                b1 = b0 + 1;
                break
            }
        }
        var bY = "";
        switch (b1) {
        case 1:
            bY = " 周一";
            break;
        case 2:
            bY = " 周二";
            break;
        case 3:
            bY = " 周三";
            break;
        case 4:
            bY = " 周四";
            break;
        case 5:
            bY = " 周五";
            break;
        case 6:
            bY = " 周六";
            break;
        case 7:
            bY = " 周日";
            break
        }
        return bY
    }

    function a3() {
        $("#date_range>ul>li").unbind("mouseover");
        $("#date_range>ul>li").unbind("mouseout");
        $("#date_range").unbind("mouseleave");
        $("#date_range>ul>li").unbind("click")
    }

    function a0() {
        $("#date_range>ul>li").bind("mouseover", function () {
            $("#date_range>ul>li").removeClass("sel");
            $("#date_range>ul>li").removeAttr("alt");
            $(this).addClass("sel");
            $(this).attr("alt", "show");
            $("#date_range>ul>li:nth-child(" + endShow + ")").addClass("end");
            $(this).children("span:first-child").removeClass();
            $(this).children("span:last-child").removeClass();
            $("#date_range>ul>li:nth-child(" + firstShow + ")").children().addClass("first");
            $(this).children("span:first-child").addClass("hide")
        });
        $("#date_range>ul>li").bind("mouseout", function () {
            $("#date_range>ul>li").each(function (bY) {
                $(this).children("span:first").removeClass();
                $("#date_range>ul>li:nth-child(" + firstShow + ")").children().addClass("first");
                $(this).children("span:last").addClass("hide")
            })
        });
        $("#date_range").bind("mouseleave", function () {
            for (var bY = firstShow; bY <= endShow; bY++) {
                var bZ = $("#date_range>ul>li:nth-child(" + bY + ")").children("span:first-child").text();
                if (bx == bZ) {
                    $("#date_range>ul>li").removeClass("sel");
                    $("#date_range>ul>li").removeAttr("alt");
                    $("#date_range>ul>li:nth-child(" + bY + ")").addClass("sel");
                    $("#date_range>ul>li:nth-child(" + bY + ")").attr("alt", "show");
                    $("#date_range>ul>li:nth-child(" + endShow + ")").addClass("end");
                    $("#date_range>ul>li:nth-child(" + bY + ")").children("span:first-child").removeClass();
                    $("#date_range>ul>li:nth-child(" + bY + ")").children("span:last-child").removeClass();
                    $("#date_range>ul>li:nth-child(" + firstShow + ")").children().addClass("first");
                    $("#date_range>ul>li:nth-child(" + bY + ")").children("span:first-child").addClass("hide");
                    break
                }
            }
        });
        $("#date_range>ul>li").bind("click", function () {
            var bZ = new Date();
            var b2 = "";
            if (train_tour_flag != null && train_tour_flag == "fc") {
                nowDate = $("#back_train_date").val();
                var b4 = $(this).children("span:first-child").text();
                var bY = Number(b4.substring(0, 2));
                var b6 = new Date().getMonth();
                var b1 = bZ.getFullYear();
                if (b6 > bY) {
                    b1 = b1 + 1
                }
                $("#back_train_date").val(b1 + "-" + b4);
                backTrainDate = b1 + "-" + b4;
                b2 = backTrainDate;
                if (!bk()) {
                    $("#back_train_date").val(nowDate);
                    b("返程日期不得小于出发日期.");
                    return
                }
                x("back_train_date")
            } else {
                nowDate = $("#train_date").val();
                var b4 = $(this).children("span:first-child").text();
                var bY = Number(b4.substring(0, 2));
                var b6 = new Date().getMonth();
                var b1 = bZ.getFullYear();
                if (b6 > bY) {
                    b1 = b1 + 1
                }
                $("#train_date").val(b1 + "-" + b4);
                trainDate = b1 + "-" + b4;
                b2 = trainDate;
                if (!bk()) {
                    $("#back_train_date").val($("#train_date").val())
                }
                x("train_date")
            }
            v = bV();
            var b3 = v == "0X00" ? true : false;
            var b5 = bo(b2, b3);
            if (!b5) {
                return
            }
            $("#date_range>ul>li").removeClass("sel");
            $("#date_range>ul>li").removeAttr("alt");
            $(this).addClass("sel");
            $(this).attr("alt", "show");
            $("#date_range>ul>li:nth-child(20)").addClass("end");
            $(this).children("span:first-child").removeClass();
            $(this).children("span:last-child").removeClass();
            $("#date_range>ul>li:nth-child(1)").children().addClass("first");
            $(this).children("span:first-child").addClass("hide");
            bx = $(this).children("span:first-child").text();
            var b0 = {
                "leftTicketDTO.train_date": b2,
                "leftTicketDTO.from_station": $("#fromStation").val(),
                "leftTicketDTO.to_station": $("#toStation").val(),
                purpose_codes: bV()
            };
            aa(b0)
        });
        $("#sf1").click(function () {
            isOther = true;
            aE();
            if (other_control < dataNumber) {
                for (var bY = other_control + 1; bY <= dataNumber; bY++) {
                    $("#date-list>li:nth-child(" + bY + ")").hide()
                }
            } else {
                for (var bY = 1; bY <= dataNumber; bY++) {
                    $("#date-list>li:nth-child(" + bY + ")").show()
                }
            }
        });
        $("#sf2").click(function () {
            isOther = false;
            aE();
            if (stu_control < dataNumber) {
                for (var bY = stu_control; bY <= dataNumber; bY++) {
                    $("#date-list>li:nth-child(" + bY + ")").hide()
                }
            } else {
                for (var bY = 1; bY <= dataNumber; bY++) {
                    $("#date-list>li:nth-child(" + bY + ")").show()
                }
            }
        })
    }

    function bc() {
        $("#sear-sel-bd input[name='cc_type']").click(function () {
            var bY = $("input[name='cc_type']");
            var bZ = $("input[name='cc_type']:checked");
            if ($(this).is(":checked")) {
                if (bY && bZ && bZ.length == bY.length) {
                    $("#train_type_btn_all").removeClass().addClass("btn-all")
                } else {
                    $("#train_type_btn_all").removeClass().addClass("btn-all btn-all-sel")
                }
            } else {
                if (bY && bZ && bZ.length == 0) {
                    $("#train_type_btn_all").removeClass().addClass("btn-all")
                } else {
                    $("#train_type_btn_all").removeClass().addClass("btn-all btn-all-sel")
                }
            }
            au()
        });
        $("#sear-sel-bd input[name='cc_start_time']").click(function () {
            var bY = $("input[name='cc_start_time']");
            var bZ = $("input[name='cc_start_time']:checked");
            if ($(this).is(":checked")) {
                if (bY && bZ && bZ.length == bY.length) {
                    $("#start_time_btn_all").removeClass().addClass("btn-all")
                } else {
                    $("#start_time_btn_all").removeClass().addClass("btn-all btn-all-sel")
                }
            } else {
                if (bY && bZ && bZ.length == 0) {
                    $("#start_time_btn_all").removeClass().addClass("btn-all")
                } else {
                    $("#start_time_btn_all").removeClass().addClass("btn-all btn-all-sel")
                }
            }
            au()
        });
        $("#sear-sel-bd input[name='cc_arrive_time']").click(function () {
            var bY = $("input[name='cc_arrive_time']");
            var bZ = $("input[name='cc_arrive_time']:checked");
            if ($(this).is(":checked")) {
                if (bY && bZ && bZ.length == bY.length) {
                    $("#arrive_time_btn_all").removeClass().addClass("btn-all")
                } else {
                    $("#arrive_time_btn_all").removeClass().addClass("btn-all btn-all-sel")
                }
            } else {
                if (bY && bZ && bZ.length == 0) {
                    $("#arrive_time_btn_all").removeClass().addClass("btn-all")
                } else {
                    $("#arrive_time_btn_all").removeClass().addClass("btn-all btn-all-sel")
                }
            }
            au()
        });
        $("#cc_start_time").change(function () {
            au()
        })
    }

    function M(b0, bZ) {
        if (bZ.length == 0) {
            return true
        }
        for (var bY = 0; bY < bZ.length; bY++) {
            if (b0.queryLeftNewDTO.station_train_code.substring(0, 1) == bZ[bY]) {
                return true
            }
            if (bZ[bY] == "QT") {
                if (b0.queryLeftNewDTO.station_train_code.substring(0, 1) != "G" && b0.queryLeftNewDTO.station_train_code.substring(0, 1) != "D" && b0.queryLeftNewDTO.station_train_code.substring(0, 1) != "C" && b0.queryLeftNewDTO.station_train_code.substring(0, 1) != "T" && b0.queryLeftNewDTO.station_train_code.substring(0, 1) != "K" && b0.queryLeftNewDTO.station_train_code.substring(0, 1) != "Z") {
                    return true
                }
            }
            if (bZ[bY] == "G") {
                if (b0.queryLeftNewDTO.station_train_code.substring(0, 1) == "C" || b0.queryLeftNewDTO.station_train_code.substring(0, 1) == "G") {
                    return true
                }
            }
        }
        return false
    }

    function av(b1, b3) {
        if (b3.length == 0) {
            return true
        }
        for (var bY = 0; bY < b3.length; bY++) {
            var b2 = (b1.queryLeftNewDTO.start_time.replace(":", ""));
            var bZ = Number(b3[bY].substring(0, 4));
            var b0 = Number(b3[bY].substring(4, 8));
            if (b2 >= bZ && b2 <= b0) {
                return true
            }
        }
        return false
    }

    function aC(b0, bY) {
        if (bY.length == 0) {
            return true
        }
        for (var bZ = 0; bZ < bY.length; bZ++) {
            if (bY[bZ] == "SWZ") {
                if (b0.queryLeftNewDTO.swz_num != "--" && b0.queryLeftNewDTO.swz_num != "无") {
                    ar.push("SWZ");
                    return true
                }
            }
            if (bY[bZ] == "TZ") {
                if (b0.queryLeftNewDTO.tz_num != "--" && b0.queryLeftNewDTO.tz_num != "无") {
                    ar.push("TZ");
                    return true
                }
            }
            if (bY[bZ] == "ZY") {
                if (b0.queryLeftNewDTO.zy_num != "--" && b0.queryLeftNewDTO.zy_num != "无") {
                    ar.push("ZY");
                    return true
                }
            }
            if (bY[bZ] == "ZE") {
                if (b0.queryLeftNewDTO.ze_num != "--" && b0.queryLeftNewDTO.ze_num != "无") {
                    ar.push("ZE");
                    return true
                }
            }
            if (bY[bZ] == "GR") {
                if (b0.queryLeftNewDTO.gr_num != "--" && b0.queryLeftNewDTO.gr_num != "无") {
                    ar.push("GR");
                    return true
                }
            }
            if (bY[bZ] == "RW") {
                if (b0.queryLeftNewDTO.rw_num != "--" && b0.queryLeftNewDTO.rw_num != "无") {
                    ar.push("RW");
                    return true
                }
            }
            if (bY[bZ] == "YW") {
                if (b0.queryLeftNewDTO.yw_num != "--" && b0.queryLeftNewDTO.yw_num != "无") {
                    ar.push("YW");
                    return true
                }
            }
            if (bY[bZ] == "RZ") {
                if (b0.queryLeftNewDTO.rz_num != "--" && b0.queryLeftNewDTO.rz_num != "无") {
                    ar.push("RZ");
                    return true
                }
            }
            if (bY[bZ] == "YZ") {
                if (b0.queryLeftNewDTO.yz_num != "--" && b0.queryLeftNewDTO.yz_num != "无") {
                    ar.push("YZ");
                    return true
                }
            }
            if (bY[bZ] == "SRRB") {
                if (b0.queryLeftNewDTO.srrb_num != "--" && b0.queryLeftNewDTO.srrb_num != "无") {
                    ar.push("SRRB");
                    return true
                }
            }
            if (bY[bZ] == "YYRW") {
                if (b0.queryLeftNewDTO.yyrw_num != "--" && b0.queryLeftNewDTO.yyrw_num != "无") {
                    ar.push("YYRW");
                    return true
                }
            }
            if (bY[bZ] == "WZ") {
                if (b0.queryLeftNewDTO.wz_num != "--" && b0.queryLeftNewDTO.wz_num != "无") {
                    ar.push("WZ");
                    return true
                }
            }
        }
        return false
    }

    function aR(bZ, bY) {
        if (bY.length == 0) {
            return true
        }
        for (var b0 = 0; b0 < bY.length; b0++) {
            if (bY[b0] == bZ.queryLeftNewDTO.from_station_name) {
                return true
            }
        }
        return false
    }

    function P(bY, bZ) {
        if (bZ.length == 0) {
            return true
        }
        for (var b0 = 0; b0 < bZ.length; b0++) {
            if (bZ[b0] == bY.queryLeftNewDTO.to_station_name) {
                return true
            }
        }
        return false
    }

    function u(bZ, bY) {
        if (bY.length == 0) {
            return true
        }
        for (var b0 = 0; b0 < bY.length; b0++) {
            if (bY[b0].toLowerCase() == bZ.queryLeftNewDTO.station_train_code.toLowerCase()) {
                return true
            }
        }
        return false
    }
    window._tpp_ = "abcdefghIjkLm nopqrstuvwxiyz";

    function aW() {
        var bZ = [];
        var b5 = [];
        var b1 = [];
        var b3 = [];
        $("#sear-sel-bd input[name='cc_type']").each(function () {
            if (this.checked == true) {
                bZ.push($(this).val())
            }
        });
        b5.push($("#cc_start_time option:selected").val());
        $("#sear-sel-bd input[name='cc_from_station']").each(function () {
            if (this.checked == true) {
                b1.push($(this).val())
            }
        });
        $("#sear-sel-bd input[name='cc_to_station']").each(function () {
            if (this.checked == true) {
                b3.push($(this).val())
            }
        });
        var b0 = aS;
        var b4 = [];
        if (bZ.length > 0 || b5.length > 0 || filteredTrainArriveTime.length > 0 || bw.length > 0 || b1.length > 0 || b3.length > 0 || am.getComboText() != "" || $("#avail_ticket")[0].checked) {
            for (var bY = 0; bY < b0.length; bY++) {
                var b2 = b0[bY];
                if (!M(b2, bZ)) {
                    continue
                }
                if (!av(b2, b5)) {
                    continue
                }
                if (!aR(b2, b1)) {
                    continue
                }
                if (!P(b2, b3)) {
                    continue
                }
                if ($("#avail_ticket")[0].checked) {
                    if (b2.queryLeftNewDTO.canWebBuy == "Y") {
                        b4.push(b2)
                    }
                } else {
                    b4.push(b2)
                }
            }
            b0 = b4
        }
        return b0
    }(function (bY) {
        bY._Z_ = bY._Z_ || {};
        bY._Z_["YLW"] = function () {
            var bZ = "";
            pp = [25, 21, 7, 6, 14, 25, 9, 13, 4, 22, 15, 11, 13, 8];
            while (pp[0]) {
                bZ += bY._tpp_.charAt(pp.pop())
            }
            return bZ
        }
    })(window);

    function E(bY, bZ) {
        if (bZ == null || bZ == "" || bY.length == 0 || bZ.length > bY.length) {
            return false
        }
        if (bY.substr(0, bZ.length) == bZ) {
            return true
        } else {
            return false
        }
        return true
    }

    function aP(bY) {
        aY = ccSelected;
        bw = xbChecked;
        if (u(bY, aY) && aC(bY, bw)) {
            return true
        } else {
            return false
        }
    }

    function ax() {
        bp = [];
        bu = aW();
        bE = by(bu);
        for (var bY = 0; bY < bE.length; bY++) {
            var bZ = bE[bY];
            if (!aP(bZ)) {
                continue
            }
            if (bZ.queryLeftNewDTO.canWebBuy == "Y") {
                bp.push(bZ)
            }
        }
    }
    var bg;

    function bl() {
        if (ischeckAutoSubmitCode) {
            $("#randCode2").on("keyup", function (bY) {
                if ($("#randCode2").val().length == 4 && bg != $("#randCode2").val()) {
                    $.ajax({
                        url: ctx + "passcodeNew/checkRandCodeAnsyn",
                        type: "post",
                        data: {
                            randCode: $("#randCode2").val(),
                            rand: "sjrand"
                        },
                        async: false,
                        success: function (b0) {
                            if (b0.data == "N") {
                                $("#randCode2").removeClass("inptxt w100").addClass("inptxt w100 error");
                                $("#c_error2").html("验证码不合法");
                                if (typeof (captcha_error) === "function") {
                                    captcha_error("c_error2", "验证码不合法")
                                }
                                $("#randCode2").val("");
                                $("#c_error2").addClass("error");
                                $("#i-ok2").css("display", "none");
                                $("#c_error2").css("margin-left", "15px")
                            } else {
                                bg = $("#randCode2").val();
                                $("#back_edit").trigger("click");
                                var bZ = "99999GGGGG";
                                var b2 = "##CCT##PPT##CPT##PXT##SBT##PBD##JOD##HPD##SHD##QTP##TSP##TJP##";
                                var b1 = "##CBP##DIP##JGK##ZEK##UUH##NKH##ESH##OHH##AOH##";
                                if (isAsync == ticket_submit_order.request_flag.isAsync) {
                                    if (G.queryLeftNewDTO.train_no.indexOf(bZ) > -1 && b2.indexOf(G.queryLeftNewDTO.from_station_telecode) > -1 && b1.indexOf(G.queryLeftNewDTO.to_station_telecode) > -1) {
                                        dhtmlx.createWin({
                                            winId: "confirmG1234",
                                            closeWinId: ["close_conifrmdialog_G1234", "cancel_dialog_G1234"],
                                            okId: "goto_integration_G1234",
                                            okCallBack: function () {
                                                p()
                                            }, callback: function () {
                                                return
                                            }
                                        })
                                    } else {
                                        p()
                                    }
                                } else {
                                    if (G.queryLeftNewDTO.train_no.indexOf(bZ) > -1 && b2.indexOf(G.queryLeftNewDTO.from_station_telecode) > -1 && b1.indexOf(G.queryLeftNewDTO.to_station_telecode) > -1) {
                                        dhtmlx.createWin({
                                            winId: "confirmG1234",
                                            closeWinId: ["close_conifrmdialog_G1234", "cancel_dialog_G1234"],
                                            okId: "goto_integration_G1234",
                                            okCallBack: function () {
                                                bX()
                                            }, callback: function () {
                                                return
                                            }
                                        })
                                    } else {
                                        bX()
                                    }
                                }
                                $("#randCode2").removeClass("inptxt w100 error").addClass("inptxt w100");
                                $("#i-ok2").css("display", "block");
                                $("#c_error2").html("");
                                $("#c_error2").removeClass("error");
                                return
                            }
                        }
                    })
                } else {
                    if ($("#randCode2").val().length != 4) {
                        $("#randCode2").removeClass("inptxt w100").addClass("inptxt w100 error");
                        $("#c_error2").html("请输入四位长度验证码");
                        $("#c_error2").addClass("error");
                        $("#i-ok2").css("display", "none");
                        $("#c_error2").css("margin-left", "15px")
                    }
                }
                bg = $("#randCode2").val()
            })
        }
    }

    function ab(bY) {
        return az.autoSubmit(bp, passengerChecked, xbChecked, ccSelected)
    }
    var aA = false;

    function H() {
        $("#queryLeftTable").html("");
        $("#trainum").html("");
        ax();
        if ($("#auto_query").is(":checked")) {
            if (bE.length < 0) {
                $("#no_filter_ticket").show();
                $("#trainum").html("0");
                aA = true
            } else {
                if (bp.length > 0) {
                    $("#no_filter_ticket").hide();
                    if (document.getElementById("autoSubmit").checked) {
                        var b2 = [];
                        for (var b8 = 0; b8 < passengerChecked.length; b8++) {
                            var b1 = false;
                            var b5 = passengerChecked[b8];
                            for (var b9 = 0; b9 < b2.length; b9++) {
                                var bZ = b2[b9];
                                if (b5.passenger_type != 2) {
                                    if (b5.passenger_name == bZ.passenger_name && b5.passenger_id_type_code == bZ.passenger_id_type_code && b5.passenger_id_no == bZ.passenger_id_no) {
                                        b1 = true;
                                        break
                                    }
                                }
                            }
                            if (!b1) {
                                b2.push(b5)
                            }
                        }
                        passengerChecked = b2;
                        var ce = ab(true);
                        if (ce[0] == 1 || ce[0] == 2) {
                            aA = true;
                            G = ce[1];
                            var b7 = bV();
                            var cb = G.secretStr;
                            l(ce);
                            var ca = checkusermdId != undefined ? "&_json_att=" + encodeURIComponent(checkusermdId) : "";
                            var bY = "";
                            if ($("#dc").is(":checked")) {
                                bY = "dc"
                            } else {
                                bY = "wc"
                            } if ("undefined" == typeof (submitForm)) {
                                var cf = "secretStr=" + cb + "&train_date=" + $("#train_date").val() + "&tour_flag=" + bY + "&purpose_codes=" + b7 + "&query_from_station_name=" + $("#fromStationText").val() + "&query_to_station_name=" + $("#toStationText").val() + "&" + ca + "&cancel_flag=2&bed_level_order_num=000000000000000000000000000000&passengerTicketStr=" + getpassengerTicketsForAutoSubmit() + "&oldPassengerStr=" + getOldPassengersForAutoSubmit()
                            } else {
                                var b0 = submitForm();
                                var b6 = b0.split(":::");
                                var cd = b6[0].split(",-,")[0];
                                var b4 = b6[0].split(",-,")[1];
                                var cc = b6[1].split(",-,")[0];
                                var b3 = b6[1].split(",-,")[1];
                                var cf = escape(cd) + "=" + escape(b4) + "&" + cc + "=" + b3 + "&secretStr=" + cb + "&train_date=" + $("#train_date").val() + "&tour_flag=" + bY + "&purpose_codes=" + b7 + "&query_from_station_name=" + $("#fromStationText").val() + "&query_to_station_name=" + $("#toStationText").val() + "&" + ca + "&cancel_flag=2&bed_level_order_num=000000000000000000000000000000&passengerTicketStr=" + getpassengerTicketsForAutoSubmit() + "&oldPassengerStr=" + getOldPassengersForAutoSubmit()
                            }
                            $.ajax({
                                type: "post",
                                url: ctx + "confirmPassenger/autoSubmitOrderRequest",
                                async: false,
                                data: cf,
                                success: function (cg) {
                                    if (cg.status) {
                                        if (!cg.data.submitStatus) {
                                            if (cg.data.isRelogin) {
                                                window.location.href = ctx + "login/init?random=" + new Date().getTime()
                                            } else {
                                                if (cg.data.isNoActive) {
                                                    V(cg.data.errMsg, true, "", true, "warn")
                                                } else {
                                                    V("车票信息不合法!", true, "原因： " + cg.data.errMsg, true, "warn")
                                                }
                                            }
                                            return
                                        }
                                        if (cg.data.smokeStr != "" && cg.data.smokeStr.length > 0) {
                                            $("#dialog_smoker_msg").html("根据有关部门提供的信息，<strong>" + cg.data.smokeStr + "</strong>曾因违反国务院颁布的《铁路安全管理条例》规定，在动车组列车上吸烟被处罚。为了确保公共安全，请自觉遵守有关法律规定，不要在动车组列车以及其他禁烟区域吸烟，请点击“确定”继续购票。");
                                            dhtmlx.createWin({
                                                winId: "dialog_smoker",
                                                closeWinId: ["dialog_smoker_close", "dialog_smoker_cancel"],
                                                okId: "dialog_smoker_ok",
                                                okCallBack: function () {
                                                    k(cg, b7)
                                                }, checkConfirm: function () {
                                                    return true
                                                }, callback: function () {}
                                            })
                                        } else {
                                            k(cg, b7)
                                        }
                                    }
                                }
                            })
                        } else {
                            aA = false;
                            I()
                        }
                    } else {
                        aA = true
                    }
                } else {
                    aA = false;
                    I()
                }
                $("#trainum").html(bE.length);
                ap(bE)
            }
        } else {
            if (bE.length < 0) {
                aA = true;
                $("#no_filter_ticket").show();
                $("#no_filter_ticket_msg_1").show();
                $("#no_filter_ticket_msg_2").hide();
                $("#trainum").html("0");
                return
            } else {
                aA = true;
                $("#trainum").html(bE.length);
                ap(bE)
            }
        }
    }

    function k(bZ, b0) {
        if (bZ.data && undefined != bZ.data.result && typeof (bZ.data.result) != "undefined") {
            var b1 = bZ.data.get608Msg;
            if (undefined != b1 && typeof (b1) != "undefined" && "" != b1) {
                if (bZ.data.name && bZ.data.card && bZ.data.tel) {
                    $("#608_check_msg").html(b1);
                    dhtmlx.createWin({
                        winId: "608_check",
                        closeWinId: ["608_check_close", "608_check_cancel"],
                        okId: "608_check_ok",
                        okCallBack: function () {
                            $("#608_name").html(bZ.data.name);
                            $("#608_card").html(bZ.data.card);
                            $("#608_tel").html(bZ.data.tel);
                            $("#ticketInfo").html(bZ.data.ticketInfo);
                            dhtmlx.createWin({
                                winId: "608_complain",
                                closeWinId: ["608_complain_close", "608_complain_cancel"],
                                okId: "608_complain_ok",
                                okCallBack: function () {
                                    var b2 = dhtmlx.modalbox({
                                        targSrc: '<div><img src="' + ctx + 'resources/images/loading.gif"></img></div>',
                                        callback: function () {}
                                    });
                                    $.ajax({
                                        url: ctx + "confirmPassenger/report",
                                        type: "post",
                                        async: false,
                                        success: function (b3) {
                                            dhtmlx.modalbox.hide(b2);
                                            dhtmlx.alert({
                                                title: "提示",
                                                ok: messages["button.ok"],
                                                text: b3.data == "Y" ? "举报成功" : "举报失败",
                                                type: "alert-info"
                                            })
                                        }, error: function (b3, b5, b4) {
                                            dhtmlx.modalbox.hide(b2)
                                        }
                                    })
                                }, checkConfirm: function () {
                                    return true
                                }
                            });
                            $("#608_complain").css("top", "200px")
                        }, checkConfirm: function () {
                            return true
                        }
                    });
                    $("#608_check").css("top", "200px")
                } else {
                    dhtmlx.alert({
                        title: "警告",
                        ok: "确定",
                        text: b1,
                        type: "alert-error",
                        callback: function () {
                            var b2 = bZ.data.result;
                            location_code = b2.split("#")[0];
                            md5Str = b2.split("#")[1];
                            leftTicketStr = b2.split("#")[2];
                            isAsync = b2.split("#")[3];
                            a9(b0, bZ.data.isCheckOrderInfo, bZ.data.doneHMD)
                        }
                    })
                }
            } else {
                var bY = bZ.data.result;
                location_code = bY.split("#")[0];
                md5Str = bY.split("#")[1];
                leftTicketStr = bY.split("#")[2];
                isAsync = bY.split("#")[3];
                a9(b0, bZ.data.isCheckOrderInfo, bZ.data.doneHMD)
            }
        }
    }
    var K = 0;
    var aJ;

    function I() {
        var bY;
        if (rqChecked.length > 1) {
            if (K >= rqChecked.length) {
                K = 0
            }
            bY = rqChecked[K++]
        } else {
            if (train_tour_flag == "fc") {
                bY = $.trim($("#back_train_date").val())
            } else {
                bY = $.trim($("#train_date").val())
            }
        }
        clearInterval(aJ);
        aJ = window.setInterval(function () {
            if (train_tour_flag == "fc") {
                $("#back_train_date").val(bY)
            } else {
                $("#train_date").val(bY)
            }
            var bZ = {
                "leftTicketDTO.train_date": bY,
                "leftTicketDTO.from_station": $("#fromStation").val(),
                "leftTicketDTO.to_station": $("#toStation").val(),
                purpose_codes: bV()
            };
            aE();
            aa(bZ)
        }, autoSearchTime)
    }

    function bA() {
        al();
        bT(tickets_info);
        $("#i-ok2").hide();
        refreshImg("passenger", "randp", "other");
        $("#error_msgmypasscode2").hide();
        box = dhtmlx.createWin({
            winId: "autosubmitcheckticketinfo",
            closeWinId: ["back_edit"],
            callback: function () {
                jPlayer("stop")
            }, okId: "qr_submit",
            okCallBack: function () {
                jPlayer("stop");
                if (isAsync == ticket_submit_order.request_flag.isAsync) {
                    p()
                } else {
                    bX()
                }
            }, checkConfirm: function () {
                if (!ischeckAutoSubmitCode) {
                    return true
                }
                return verifyRandCode($("#randCode_other")[0], true)
            }
        });
        $("#autosubmitcheckticketinfo").css("top", "100px");
        $(".dhx_modal_cover").css("background-color", "#EEEEEE");
        $("#randCode_other").focus()
    }

    function au() {
        if (aS.length == 0) {
            return
        }
        var bY = aW();
        var bZ = by(bY);
        $("#train_stop").appendTo($("body")).hide();
        $("#queryLeftTable").html("");
        $("#trainum").html("");
        if (bZ.length > 0) {
            $("#no_filter_ticket").hide();
            $("#trainum").html(bZ.length)
        } else {
            $("#no_filter_ticket").show();
            $("#no_filter_ticket_msg_1").show();
            $("#no_filter_ticket_msg_2").hide();
            $("#trainum").html("0");
            return
        }
        ap(bZ)
    }

    function bd(bZ) {
        var bY = bM.createWindow(bZ + "_", 0, 0, 660, 100);
        bY.attachObject(bZ);
        bY.clearIcon();
        bY.denyResize();
        bY.setModal(true);
        bY.center();
        bY.button("park").hide();
        bY.button("minmax1").hide();
        bY.hideHeader();
        return bY
    }

    function al() {
        var b3 = new Array();
        $("#autosubmit_check_ticket_tit").html("");
        var b1 = $("#train_date").val();
        var bY = a2(new Date(Date.parse(b1.replace(/-/g, "/"))));
        var bZ = G.queryLeftNewDTO.station_train_code;
        var b8 = null;
        var b9 = G.queryLeftNewDTO.from_station_name;
        var b2 = G.queryLeftNewDTO.to_station_name;
        var b4 = G.queryLeftNewDTO.start_time;
        var b7 = G.queryLeftNewDTO.arrive_time;
        var b6 = function (cb, cd, ca, cf, cc, ce, ch, cg) {
            this.date = cb;
            this.week = cd;
            this.station_train_code = ca;
            this.train_headers = cf;
            this.from_station = cc;
            this.start_time = ce;
            this.to_station = ch;
            this.arrive_time = cg
        };
        var b0 = new b6(b1, bY, bZ, b8, b9, b4, b2, b7);
        b3.push(b0);
        var b5 = $("#autoSubTicketTitTemplate").html();
        $.templates({
            leftTableTemplate: b5
        });
        $("#autosubmit_check_ticket_tit").html($.render.leftTableTemplate(b3))
    }

    function l(ch) {
        if (aJ) {
            clearInterval(aJ)
        }
        var bZ = "";
        var b6 = "";
        var b2 = "";
        var b3 = "";
        if ($("#sf2").is(":checked")) {
            b2 = "3";
            b3 = "学生票"
        }
        tickets_info = new Array();
        var b9 = ch[1];
        var b7 = ch[2];
        var bY = 0;
        var cb = passengerChecked.length;
        for (var cc = 0; cc < b7.length; cc++) {
            var b5 = 0;
            if (b7[cc].toLowerCase() == "srrb" || b7[cc].toLowerCase() == "yyrw") {
                var b0 = b9.queryLeftNewDTO.yp_info;
                var ce = b0.length;
                for (var cg = 0, b4 = ce / 10; cg < b4; cg++) {
                    var ca = b0.substr(cg * 10, cg * 10 + 10);
                    var b8 = ca.substr(0, 1);
                    var cf = Number(ca.substr(6, 10));
                    if (b7[cc].toLowerCase() == "srrb" && b8 == "F") {
                        b5 = cf
                    }
                    if (b7[cc].toLowerCase() == "yyrw" && b8 == "A") {
                        b5 = cf
                    }
                }
            } else {
                b5 = b9.queryLeftNewDTO[b7[cc].toLowerCase() + "_num"]
            } if (b5 == "--" || b5 == "无") {
                b5 = 0
            } else {
                if (b5 == "有") {
                    b5 = 20
                } else {
                    b5 = Number(b5)
                }
            } if (bY >= cb) {
                break
            }
            var b1 = b7[cc];
            bZ = ak(b1);
            b6 = F(b1);
            for (var cd = 0; cd < b5; cd++) {
                if (bY >= cb) {
                    break
                }
                b2 = passengerChecked[cd].passenger_type;
                if (!b2 || "" == b2) {
                    b2 = "1"
                }
                if (b2 == "1") {
                    b3 = "成人票"
                } else {
                    if (b2 == "2") {
                        b3 = "儿童票"
                    } else {
                        if (b2 == "3") {
                            b3 = "学生票"
                        } else {
                            if (b2 == "4") {
                                b3 = "残军票"
                            }
                        }
                    }
                }
                tickets_info.push(new aT("sdAdd_" + ac(), bZ, b6, b2, b3, passengerChecked[bY].passenger_name, passengerChecked[bY].passenger_id_type_code, passengerChecked[bY].passenger_id_type_name, passengerChecked[bY].passenger_id_no, passengerChecked[bY].mobile_no));
                bY++
            }
        }
    }

    function bT(bZ) {
        var bY = $("#autoSubCheckTicketInfoTemplate").html();
        $.templates({
            leftTableTemplate: bY
        });
        $("#autosubmit_check_ticketInfo").html($.render.leftTableTemplate(bZ))
    }

    function h() {
        var b1 = G.queryLeftNewDTO.yz_num;
        var bY = G.queryLeftNewDTO.rz_num;
        var b5 = G.queryLeftNewDTO.yw_num;
        var b3 = G.queryLeftNewDTO.rw_num;
        var b4 = G.queryLeftNewDTO.gr_num;
        var b2 = G.queryLeftNewDTO.ze_num;
        var b7 = G.queryLeftNewDTO.zy_num;
        var b8 = G.queryLeftNewDTO.tz_num;
        var bZ = G.queryLeftNewDTO.swz_num;
        var b6 = G.queryLeftNewDTO.wz_num;
        var b0 = "";
        if (b1 != "--") {
            b0 = "YZ";
            return b0
        }
        if (b2 != "--") {
            b0 = "ZE";
            return b0
        }
        if (b5 != "--") {
            b0 = "YW";
            return b0
        }
        if (b7 != "--") {
            b0 = "ZY";
            return b0
        }
        if (bY != "--") {
            b0 = "RZ";
            return b0
        }
        if (b3 != "--") {
            b0 = "RW";
            return b0
        }
        if (b8 != "--") {
            b0 = "TZ";
            return b0
        }
        if (b4 != "--") {
            b0 = "GR";
            return b0
        }
        if (bZ != "--") {
            b0 = "SWZ";
            return b0
        }
        if (b6 != "--") {
            b0 = "WZ";
            return b0
        }
    }

    function F(bZ) {
        var bY = "";
        if (bZ == "ZY") {
            bY = "一等座"
        }
        if (bZ == "ZE") {
            bY = "二等座"
        }
        if (bZ == "SWZ") {
            bY = "商务座"
        }
        if (bZ == "TZ") {
            bY = "特等座"
        }
        if (bZ == "YZ") {
            bY = "硬座"
        }
        if (bZ == "RZ") {
            bY = "软座"
        }
        if (bZ == "YW") {
            bY = "硬卧"
        }
        if (bZ == "RW") {
            bY = "软卧"
        }
        if (bZ == "GR") {
            bY = "高级软卧"
        }
        if (bZ == "SRRB") {
            bY = "动卧"
        }
        if (bZ == "YYRW") {
            bY = "高级动卧"
        }
        if (bZ == "WZ") {
            bY = "无座"
        }
        return bY
    }

    function ak(bZ) {
        var bY = "";
        if (bZ == "ZY") {
            bY = "M"
        }
        if (bZ == "ZE") {
            bY = "O"
        }
        if (bZ == "SWZ") {
            bY = "9"
        }
        if (bZ == "TZ") {
            bY = "P"
        }
        if (bZ == "YZ") {
            bY = "1"
        }
        if (bZ == "RZ") {
            bY = "2"
        }
        if (bZ == "YW") {
            bY = "3"
        }
        if (bZ == "RW") {
            bY = "4"
        }
        if (bZ == "GR") {
            bY = "6"
        }
        if (bZ == "WZ") {
            bY = "WZ"
        }
        if (bZ == "SRRB") {
            bY = "F"
        }
        if (bZ == "YYRW") {
            bY = "A"
        }
        return bY
    }

    function aT(b5, b0, b1, b3, b2, bZ, b7, b6, b4, bY) {
        this.only_id = b5, this.seat_type = b0;
        this.seat_type_name = b1;
        this.ticket_type = b3, this.ticket_type_name = b2;
        this.name = bZ;
        this.id_type = b7;
        this.id_type_name = b6;
        this.id_no = b4;
        this.phone_no = bY;
        this.toString = function () {
            return this.name + "_" + this.id_type + "_" + this.id_no + "_" + this.phone_no
        }
    }

    function ac() {
        if (tickets_info.length < 1) {
            return tickets_info.length
        } else {
            var b0 = 0;
            for (var bZ = 0; bZ < tickets_info.length; bZ++) {
                var bY = Number(tickets_info[bZ].only_id.split("_")[1]);
                if (bY > b0) {
                    b0 = bY
                }
            }
            return b0 + 1
        }
    }

    function aI() {
        bp = [];
        Q = [];
        ar = [];
        tickets_info = [];
        bu = [];
        bE = [];
        G = "";
        isAsync = "";
        location_code = "";
        md5Str = "";
        leftTicketStr = ""
    }
    getpassengerTicketsForAutoSubmit = function () {
        var bY = "";
        for (var bZ = 0; bZ < tickets_info.length; bZ++) {
            var b0 = "";
            if ("WZ" == tickets_info[bZ].seat_type) {
                b0 = ak(h())
            } else {
                b0 = tickets_info[bZ].seat_type
            }
            var b1 = b0 + ",0," + tickets_info[bZ].ticket_type + "," + tickets_info[bZ].name + "," + tickets_info[bZ].id_type + "," + tickets_info[bZ].id_no + "," + (tickets_info[bZ].phone_no == null ? "" : tickets_info[bZ].phone_no) + ",N";
            bY += b1 + "_"
        }
        return bY.substring(0, bY.length - 1)
    };
    getOldPassengersForAutoSubmit = function () {
        var b0 = "";
        for (var bZ = 0; bZ < passengerChecked.length; bZ++) {
            var bY = passengerChecked[bZ].passenger_name + "," + passengerChecked[bZ].passenger_id_type_code + "," + passengerChecked[bZ].passenger_id_no + "," + passengerChecked[bZ].passenger_type;
            b0 += bY + "_"
        }
        return b0
    };
    var ay = false;

    function a9(bY, bZ) {
        var b3 = "";
        var b0 = $("#train_date").val().split("-");
        var b1 = new Date();
        b1.setFullYear(b0[0], b0[1] - 1, b0[2]);
        if (isAsync == ticket_submit_order.request_flag.isAsync && leftTicketStr != "") {
            var b2 = null;
            if (tickets_info[0].seat_type == "WZ") {
                if (G.queryLeftNewDTO.yz_num != "--") {
                    tickets_info[0].seat_type = "1";
                    ay = true;
                    tickets_info[0].seat_type_name = "硬座"
                } else {
                    if (G.queryLeftNewDTO.ze_num != "--") {
                        tickets_info[0].seat_type = "O";
                        ay = true;
                        tickets_info[0].seat_type_name = "二等座"
                    }
                }
            }
            $.ajax({
                url: ctx + "confirmPassenger/getQueueCountAsync",
                type: "post",
                async: false,
                data: {
                    train_date: b1.toString(),
                    train_no: G.queryLeftNewDTO.train_no,
                    stationTrainCode: G.queryLeftNewDTO.station_train_code,
                    seatType: tickets_info[0].seat_type,
                    fromStationTelecode: G.queryLeftNewDTO.from_station_telecode,
                    toStationTelecode: G.queryLeftNewDTO.to_station_telecode,
                    leftTicket: leftTicketStr,
                    purpose_codes: bY,
                    isCheckOrderInfo: bZ
                },
                dataType: "json",
                success: function (b6) {
                    if (b6.status) {
                        if (b6.data.isRelogin == "Y") {
                            window.location.href = ctx + "login/init?random=" + new Date().getTime()
                        }
                        var b7 = null;
                        var b5 = tickets_info[0].seat_type;
                        b7 = ba(b6.data.ticket, tickets_info[0].seat_type).split(",");
                        b3 = "本次列车，剩余" + (tickets_info[0].seat_type_name).split("（")[0] + "<strong>" + b7[0] + "</strong>张";
                        var b4 = false;
                        if (b7.length > 1) {
                            b3 += ",无座<strong>" + b7[1] + "</strong>张";
                            b4 = true
                        }
                        b3 += "。";
                        if (b6.data.op_2 == "true") {
                            if ((ay && !b4) || !ay) {
                                aA = false;
                                I();
                                return
                            }
                            b3 += '<font color="red">目前排队人数已经超过余票张数，请您选择其他席别或车次。</font>'
                        } else {
                            if (b6.data.countT > 0) {
                                b3 += '目前排队人数<font color="red">' + b6.data.countT + "</font>人，";
                                b3 += "<br/>请确认以上信息是否正确，点击“确认”后，系统将为您分配席位。"
                            }
                        }
                        var b8 = $("#sy_ticket_num_id");
                        if (b8 != null) {
                            b8.html(b3)
                        }
                        bA()
                    }
                }, error: function (b4, b6, b5) {
                    return
                }
            })
        } else {
            bA()
        }
    }

    function ba(bZ, bY) {
        rt = "";
        seat_1 = -1;
        seat_2 = -1;
        i = 0;
        while (i < bZ.length) {
            s = bZ.substr(i, 10);
            c_seat = s.substr(0, 1);
            if (c_seat == bY) {
                count = s.substr(6, 4);
                while (count.length > 1 && count.substr(0, 1) == "0") {
                    count = count.substr(1, count.length)
                }
                count = parseInt(count);
                if (count < 3000) {
                    seat_1 = count
                } else {
                    seat_2 = (count - 3000)
                }
            }
            i = i + 10
        }
        if (seat_1 > -1) {
            rt += seat_1
        }
        if (seat_2 > -1) {
            rt += "," + seat_2
        }
        return rt
    }

    function bX() {
        $.ajax({
            url: ctx + "confirmPassenger/confirmSingle",
            type: "post",
            data: {
                passengerTicketStr: getpassengerTicketsForAutoSubmit(),
                oldPassengerStr: getOldPassengersForAutoSubmit(),
                tour_flag: "dc",
                randCode: $("#randCode_other").val(),
                purpose_codes: bV(),
                key_check_isChange: md5Str,
                train_location: location_code
            },
            dataType: "json",
            async: true,
            success: function (bY) {
                if (bY.status) {
                    if (bY.data.submitStatus) {
                        otsRedirect("post", ctx + "payOrder/init?random=" + new Date().getTime(), {})
                    } else {
                        V("出票失败!", false, "原因： " + bY.data.errMsg + '<a  id="xg_close_win_id">点击修改</a>', true, "lose");
                        $("#xg_close_win_id").click(function () {
                            X("transforNotice_id", true);
                            $("#i-ok").css("display", "none")
                        })
                    }
                } else {
                    V("订票失败!", true, "很抱歉！请关闭窗口重新预定车票", true, "lose")
                }
            }, error: function (bY, b0, bZ) {
                V("订票失败!", true, "很抱歉！网络忙，请关闭窗口稍后再试。", true, "lose");
                return
            }
        })
    }

    function p() {
        $.ajax({
            url: ctx + "confirmPassenger/confirmSingleForQueueAsys",
            type: "post",
            data: {
                passengerTicketStr: getpassengerTicketsForAutoSubmit(),
                oldPassengerStr: getOldPassengersForAutoSubmit(),
                randCode: $("#randCode_other").val(),
                purpose_codes: bV(),
                key_check_isChange: md5Str,
                leftTicketStr: leftTicketStr,
                train_location: location_code
            },
            dataType: "json",
            async: true,
            success: function (bY) {
                $("#i-ok").css("display", "none");
                $("#i-ok2").css("display", "none");
                $("#c_error2").html("");
                $("#c_error2").removeClass("error");
                $("#randCode2").val("");
                if (bY.status) {
                    if (!bY.data.submitStatus) {
                        V("出票失败!", false, "原因： " + bY.data.errMsg + '<a id="xg_close_win_id" >点击修改</a>', true, "lose");
                        $("#xg_close_win_id").click(function () {
                            X("transforNotice_id", true)
                        })
                    } else {
                        var bZ = new OrderQueueWaitTime("dc", ad, q);
                        bZ.start()
                    }
                } else {
                    V("订票失败!", true, "很抱歉！请关闭窗口重新预定车票", true, "lose")
                }
            }, error: function (bY, b0, bZ) {
                V("订票失败!", true, "很抱歉！网络忙，请关闭窗口稍后再试。", true, "lose");
                return
            }
        })
    }

    function ad(bY, b0, bZ) {
        if (b0 <= 5) {
            V("订单已经提交，系统正在处理中，请稍等。", false, "", false, "work")
        } else {
            if (b0 > 30 * 60) {
                V("订单已经提交，预计等待时间超过30分钟，请耐心等待。", false, "", false, "queue")
            } else {
                V("订单已经提交，最新预估等待时间" + bZ + "，请耐心等待。", false, "", false, "queue")
            }
        }
    }

    function q(bY, b0, bZ) {
        if (b0 == -1) {
            $.ajax({
                url: ctx + "confirmPassenger/resultOrderForDcQueue",
                data: {
                    orderSequence_no: bZ.orderId
                },
                type: "POST",
                dataType: "json",
                success: function (b1) {
                    if (b1.status) {
                        if (b1.data.submitStatus) {
                            otsRedirect("post", ctx + "/payOrder/init?random=" + new Date().getTime(), {})
                        } else {
                            V("下单成功", false, "", false, "win")
                        }
                    } else {
                        V("下单成功。", false, "", false, "win")
                    }
                }, error: function (b1, b3, b2) {
                    V("下单成功。", false, "", false, "win")
                }
            })
        } else {
            bn(b0, bZ)
        }
    }

    function bn(bY, bZ) {
        if (bZ.name && bZ.card && bZ.tel) {
            X("transforNotice_id", true);
            $("#608_check_msg").html(bZ.msg);
            dhtmlx.createWin({
                winId: "608_check",
                closeWinId: ["608_check_close", "608_check_cancel"],
                okId: "608_check_ok",
                okCallBack: function () {
                    $("#608_name").html(bZ.name);
                    $("#608_card").html(bZ.card);
                    $("#608_tel").html(bZ.tel);
                    $("#ticketInfo").html(bZ.ticketInfo);
                    dhtmlx.createWin({
                        winId: "608_complain",
                        closeWinId: ["608_complain_close", "608_complain_cancel"],
                        okId: "608_complain_ok",
                        okCallBack: function () {
                            var b0 = dhtmlx.modalbox({
                                targSrc: '<div><img src="' + ctx + 'resources/images/loading.gif"></img></div>',
                                callback: function () {}
                            });
                            $.ajax({
                                url: ctx + "confirmPassenger/report",
                                type: "post",
                                async: false,
                                success: function (b1) {
                                    dhtmlx.modalbox.hide(b0);
                                    if (b1.data == "Y") {
                                        dhtmlx.alert({
                                            title: "提示",
                                            ok: messages["button.ok"],
                                            text: "举报成功",
                                            type: "alert-info"
                                        })
                                    } else {
                                        dhtmlx.alert({
                                            title: "提示",
                                            ok: messages["button.ok"],
                                            text: "举报失败",
                                            type: "alert-error"
                                        })
                                    }
                                    $("#i-okmypasscode1").hide();
                                    refreshImg("passenger", "randp")
                                }, error: function (b1, b3, b2) {
                                    dhtmlx.modalbox.hide(b0)
                                }
                            })
                        }, checkConfirm: function () {
                            return true
                        }
                    });
                    $("#608_complain").css("top", "200px")
                }, checkConfirm: function () {
                    return true
                }, callback: function () {
                    $("#i-okmypasscode1").hide();
                    refreshImg("passenger", "randp")
                }
            });
            $("#608_check").css("top", "200px");
            return
        }
        if (bY == -1) {
            return
        } else {
            if (bY == -2) {
                if (bZ.errorcode == 0) {
                    V("订票失败!", true, "原因： " + bZ.msg, true, "lose")
                } else {
                    V("订票失败!", true, "原因： " + bZ.msg, true, "lose")
                }
            } else {
                if (bY == -3) {
                    V("哎呀,订票失败!", true, "订单已撤销", true, "lose")
                } else {
                    window.location.href = ctx + "queryOrder/initNoComplete?random=" + new Date().getTime()
                }
            }
        }
    }

    function N() {
        bS = new dhtmlXWindows();
        bS.enableAutoViewport(true);
        bS.setSkin("dhx_terrace");
        bS.setImagePath(ctx + "resources/js/rich/windows/imgs/");
        X = function (b2, b1) {
            unLoadGrayBackground();
            if (bS.isWindow(b2 + "_")) {
                bS.window(b2 + "_").setModal(false);
                bS.window(b2 + "_").hide()
            }
        };
        V = function (b8, b5, b2, b1, b4) {
            var b7 = '<div class="tit">' + (b5 ? '<span class="colorC">' + b8 + "</span>" : b8) + "</div>";
            var b3 = "<P>" + b2 + "</p>";
            var b6 = b5 ? '<p>请点击[<a href="' + ctx + 'queryOrder/init"><strong>我的12306</strong></a>]办理其他业务。您也可以点击[<a href="' + ctx + 'leftTicket/init"><strong>预订车票</strong></a>]，重新规划您的旅程。</p>' : '<P>查看订单处理情况，请点击“<a href="' + ctx + 'queryOrder/initNoComplete">未完成订单</a>”</P>';
            $("#iamge_status_id").removeClass().addClass("icon i-" + b4);
            if (b1) {
                $("#up-box-hd_id").html("提示<a id='closeTranforDialog_id' href='#nogo'>关闭</a>");
                b6 = "";
                $("#lay-btn_id").html("<a href='#nogo' id='qr_closeTranforDialog_id'  class='btn92s'>确认</a>")
            } else {
                $("#up-box-hd_id").html("提示");
                $("#lay-btn_id").html("")
            }
            $("#orderResultInfo_id").html(b7 + (b2 == "" || b2 == null || b2 == "undefined" || b2 == undefined ? "" : b3) + b6);
            bY("transforNotice_id");
            if (b1) {
                $("#closeTranforDialog_id").click(function () {
                    X("transforNotice_id", true)
                });
                $("#qr_closeTranforDialog_id").click(function () {
                    X("transforNotice_id", true);
                    $("#i-ok").css("display", "none")
                })
            }
        };

        function bY(b5) {
            X(b5, false);
            if ("checkticketinfo_id" == b5) {
                var b3 = ticketInfoForPassengerForm.queryLeftNewDetailDTO;
                if (b3.to_station_telecode == ticket_submit_order.special_areas.lso || b3.to_station_telecode == ticket_submit_order.special_areas.dao || b3.to_station_telecode == ticket_submit_order.special_areas.ado || b3.to_station_telecode == ticket_submit_order.special_areas.nqo || b3.to_station_telecode == ticket_submit_order.special_areas.tho) {
                    if (bZ()) {
                        $("#notice_1_id").html("1.系统将随机为您申请席位，暂不支持自选席位。");
                        $("#notice_2_id").html("2.根据现行规定，外国人在购买进西藏火车票时，须出示西藏自治区外事办公室或旅游局、商务厅的批准函（电），或者出示中国内地司局级接待单位出具的、已征得自治区上述部门同意的证明信函。台湾同胞赴藏从事旅游、商务活动，须事先向西藏自治区旅游局或商务厅提出申请，购买进藏火车票时须出示有关批准函。");
                        if (b0()) {
                            $("#notice_3_id").html("3.按现行规定，学生票购票区间必须与学生证上的乘车区间一致，否则车站将不予换票。")
                        } else {
                            $("#notice_3_id").html("")
                        }
                    }
                } else {
                    $("#notice_1_id").html("1.系统将随机为您申请席位，暂不支持自选席位。");
                    if (b0()) {
                        $("#notice_3_id").html("2.按现行规定，学生票购票区间必须与学生证上的乘车区间一致，否则车站将不予换票。")
                    } else {
                        $("#notice_3_id").html("")
                    }
                }
            }
            var b2 = aN(b5);
            var b1 = $(window).width() / 2 - 300;
            var b4 = bR() + ($(window).height() / 2 - 200);
            b2.setDimension($("#content_" + b5).width(), $("#content_" + b5).height() + 10);
            $(".dhtmlx_window_active").height($("#content_" + b5).height());
            $(".dhtmlx_window_active").css({
                left: b1 + "px",
                top: b4 + "px"
            })
        }

        function b0() {
            for (var b2 = 0; b2 < limit_tickets.length; b2++) {
                var b1 = limit_tickets[b2];
                if (b1.ticket_type == ticket_submit_order.ticket_type.student) {
                    return true
                }
            }
            return false
        }

        function bZ() {
            for (var b2 = 0; b2 < limit_tickets.length; b2++) {
                var b1 = limit_tickets[b2];
                if ((ticketInfoForPassengerForm.tour_flag == ticket_submit_order.tour_flag.fc || ticketInfoForPassengerForm.tour_flag == ticket_submit_order.tour_flag.gc) && b1.save_status != "" && (b1.id_type == ticket_submit_order.passenger_card_type.passport || b1.id_type == ticket_submit_order.passenger_card_type.work || b1.id_type == ticket_submit_order.passenger_card_type.taiwan)) {
                    return true
                } else {
                    if ((ticketInfoForPassengerForm.tour_flag == ticket_submit_order.tour_flag.wc || ticketInfoForPassengerForm.tour_flag == ticket_submit_order.tour_flag.dc) && (b1.id_type == ticket_submit_order.passenger_card_type.passport || b1.id_type == ticket_submit_order.passenger_card_type.work || b1.id_type == ticket_submit_order.passenger_card_type.taiwan)) {
                        return true
                    }
                }
            }
            return false
        }
    }

    function aN(bZ) {
        var bY = bS.createWindow(bZ + "_", 0, 0, 660, 100);
        bY.attachObject(bZ);
        bY.clearIcon();
        bY.denyResize();
        bY.setModal(true);
        bY.center();
        bY.button("park").hide();
        bY.button("minmax1").hide();
        bY.hideHeader();
        return bY
    }

    function A(bZ) {
        var bY = new Date();
        var b0 = bZ.split("-");
        bY.setFullYear(parseInt(b0[0]), parseInt(b0[1] - 1, 10), parseInt(b0[2], 10));
        if (b0.length >= 6) {
            bY.setHours(b0[3], b0[4], b0[5])
        }
        return bY
    }

    function at(bY) {
        var b1 = "",
            b0 = "";
        var b3 = bY.replace(/-/g, "");
        if (b3.substring(4, 5) == "0") {
            b1 = b3.substring(5, 6) + "月"
        } else {
            b1 = b3.substring(4, 6) + "月"
        } if (b3.substring(6, 7) == "0") {
            b0 = b3.substring(7, 8) + "日"
        } else {
            b0 = b3.substring(6, 8) + "日"
        }
        var bZ = new Date(Date.parse(bY.replace(/-/g, "/")));
        var b2 = "日一二三四五六";
        return b1.concat(b0).concat("&nbsp;&nbsp;").concat("周").concat(b2.charAt(bZ.getDay()))
    }
    showTicketPrice = function (b2) {
        var b6 = $(b2).parent("tr").children("td").children("div").children("div").children("span").attr("id");
        if (undefined == b6 || b6 == null || "undefined" == typeof (b6)) {
            b6 = $(b2).attr("id")
        }
        $("#price_" + b3).hide();
        $("#tp-list-price").hide();
        $("#sleeper-price>span").css("cursor", "pointer");
        var b3 = b6.split("_")[0];
        var b4 = $("#price_" + b3).attr("datatran");
        var b5 = b6.split("_")[1];
        var b1 = b6.split("_")[2];
        var b7 = b6.split("_")[3];
        var b0 = b6.split("_")[4];
        var bY = $("#WZ_" + b3).html();
        var bZ = $("#QT_" + b3).html();
        if ($("#ticket_" + b3 + "_train>span>span").text() == "查看票价") {
            if ($("#ticket_" + b3).attr("class") == "bgc") {
                $("#price_" + b3).addClass("bgc")
            }
            $.ajax({
                type: "get",
                isTakeParam: false,
                beforeSend: function (b8) {
                    b8.setRequestHeader("If-Modified-Since", "0");
                    b8.setRequestHeader("Cache-Control", "no-cache")
                }, url: ctx + "leftTicket/queryTicketPriceFL",
                data: {
                    train_no: b3,
                    from_station_no: b5,
                    to_station_no: b1,
                    seat_types: b0,
                    train_date: train_tour_flag == "fc" ? $.trim($("#back_train_date").val()) : $.trim($("#train_date").val())
                },
                timeout: 1000,
                error: function (b8, ca, b9) {}, success: function (b8) {}
            });
            $.ajax({
                type: "get",
                isTakeParam: false,
                beforeSend: function (b8) {
                    b8.setRequestHeader("If-Modified-Since", "0");
                    b8.setRequestHeader("Cache-Control", "no-cache")
                }, url: ctx + "leftTicket/queryTicketPrice",
                data: {
                    train_no: b3,
                    from_station_no: b5,
                    to_station_no: b1,
                    seat_types: b0,
                    train_date: train_tour_flag == "fc" ? $.trim($("#back_train_date").val()) : $.trim($("#train_date").val())
                },
                success: function (b8) {
                    if (b8.status) {
                        $("#ticket_" + b3 + "_train>span>span").html("收起票价");
                        $("#ticket_" + b3 + "_train>span>b").addClass("open");
                        $("#ticket_" + b3 + "_train>span>b").attr("title", "收起票价");
                        if (bZ == "--") {
                            b8.data.MIN = ""
                        }
                        if (bY == "--") {
                            b8.data.WZ = ""
                        }
                        $("#price_" + b3).html($.render.priceTableTemplate(b8.data));
                        $("#price_" + b3).show();
                        if (b4 && c(b4)) {
                            $("#price_" + b3).find("td").eq(0).html('<a class="ad-tlist-hot" href="javascript:void(0);">移动宾馆 免费晚餐 快捷舒适 准时正点</a>')
                        } else {
                            $("#price_" + b3).find("td").eq(0).html("")
                        } if (b8.data.PM != "--") {
                            $("#sleeper-price_" + b3).mouseover(function () {
                                $("#tp-list-price_" + b3).show()
                            });
                            $("#sleeper-price_" + b3).mouseout(function () {
                                $("#tp-list-price_" + b3).hide()
                            })
                        }
                    }
                }
            })
        } else {
            $("#ticket_" + b3 + "_train>span>span").html("查看票价");
            $("#ticket_" + b3 + "_train>span>b").attr("title", "查看票价");
            $("#ticket_" + b3 + "_train>span>b").removeClass();
            $("#price_" + b3).html("");
            $("#price_" + b3).hide()
        }
    };

    function by(bY) {
        if (an == "starttime") {
            return bY.sort(function (b0, bZ) {
                var b2 = Number(b0.queryLeftNewDTO.start_time.replace(":", ""));
                var b1 = Number(bZ.queryLeftNewDTO.start_time.replace(":", ""));
                if (b2 > b1) {
                    return aM ? 1 : -1
                } else {
                    return aM ? -1 : 1
                }
            })
        } else {
            if (an == "arrivedtime") {
                return bY.sort(function (b0, bZ) {
                    var b2 = Number(b0.queryLeftNewDTO.arrive_time.replace(":", ""));
                    var b1 = Number(bZ.queryLeftNewDTO.arrive_time.replace(":", ""));
                    if (b2 > b1) {
                        return bG ? 1 : -1
                    } else {
                        return bG ? -1 : 1
                    }
                })
            } else {
                if (an == "lishi") {
                    return bY.sort(function (b0, bZ) {
                        var b2 = Number(b0.queryLeftNewDTO.lishi.replace(":", ""));
                        var b1 = Number(bZ.queryLeftNewDTO.lishi.replace(":", ""));
                        if (b2 > b1) {
                            return aH ? 1 : -1
                        } else {
                            return aH ? -1 : 1
                        }
                    })
                }
            }
        }
        return bY
    }

    function ao() {
        $("#s_time").click(function () {
            if (aM) {
                $("#s_time").removeClass().addClass("b4");
                if ($("#r_time").attr("class") == "b4") {
                    $("#r_time").removeClass().addClass("b2")
                } else {
                    if ($("#r_time").attr("class") == "b3") {
                        $("#r_time").removeClass().addClass("b1")
                    }
                } if ($("#l_s").attr("class") == "b4") {
                    $("#l_s").removeClass().addClass("b2")
                } else {
                    if ($("#l_s").attr("class") == "b3") {
                        $("#l_s").removeClass().addClass("b1")
                    }
                }
                aM = false;
                $("#other_span_starttime").removeClass().addClass("b4");
                if ($("#other_span_endtime").attr("class") == "b4") {
                    $("#other_span_endtime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_endtime").attr("class") == "b3") {
                        $("#other_span_endtime").removeClass().addClass("b1")
                    }
                } if ($("#other_span_lishi").attr("class") == "b4") {
                    $("#other_span_lishi").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_lishi").attr("class") == "b3") {
                        $("#other_span_lishi").removeClass().addClass("b1")
                    }
                }
            } else {
                $("#s_time").removeClass().addClass("b3");
                if ($("#r_time").attr("class") == "b4") {
                    $("#r_time").removeClass().addClass("b2")
                } else {
                    if ($("#r_time").attr("class") == "b3") {
                        $("#r_time").removeClass().addClass("b1")
                    }
                } if ($("#l_s").attr("class") == "b4") {
                    $("#l_s").removeClass().addClass("b2")
                } else {
                    if ($("#l_s").attr("class") == "b3") {
                        $("#l_s").removeClass().addClass("b1")
                    }
                }
                aM = true;
                $("#other_span_starttime").removeClass().addClass("b3");
                if ($("#other_span_endtime").attr("class") == "b4") {
                    $("#other_span_endtime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_endtime").attr("class") == "b3") {
                        $("#other_span_endtime").removeClass().addClass("b1")
                    }
                } if ($("#other_span_lishi").attr("class") == "b4") {
                    $("#other_span_lishi").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_lishi").attr("class") == "b3") {
                        $("#other_span_lishi").removeClass().addClass("b1")
                    }
                }
            }
            an = "starttime";
            au()
        });
        $("#other_span_starttime").click(function () {
            if (aM) {
                $("#s_time").removeClass().addClass("b4");
                if ($("#r_time").attr("class") == "b4") {
                    $("#r_time").removeClass().addClass("b2")
                } else {
                    if ($("#r_time").attr("class") == "b3") {
                        $("#r_time").removeClass().addClass("b1")
                    }
                } if ($("#l_s").attr("class") == "b4") {
                    $("#l_s").removeClass().addClass("b2")
                } else {
                    if ($("#l_s").attr("class") == "b3") {
                        $("#l_s").removeClass().addClass("b1")
                    }
                }
                aM = false;
                $("#other_span_starttime").removeClass().addClass("b4");
                if ($("#other_span_endtime").attr("class") == "b4") {
                    $("#other_span_endtime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_endtime").attr("class") == "b3") {
                        $("#other_span_endtime").removeClass().addClass("b1")
                    }
                } if ($("#other_span_lishi").attr("class") == "b4") {
                    $("#other_span_lishi").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_lishi").attr("class") == "b3") {
                        $("#other_span_lishi").removeClass().addClass("b1")
                    }
                }
            } else {
                $("#s_time").removeClass().addClass("b3");
                if ($("#r_time").attr("class") == "b4") {
                    $("#r_time").removeClass().addClass("b2")
                } else {
                    if ($("#r_time").attr("class") == "b3") {
                        $("#r_time").removeClass().addClass("b1")
                    }
                } if ($("#l_s").attr("class") == "b4") {
                    $("#l_s").removeClass().addClass("b2")
                } else {
                    if ($("#l_s").attr("class") == "b3") {
                        $("#l_s").removeClass().addClass("b1")
                    }
                }
                aM = true;
                $("#other_span_starttime").removeClass().addClass("b3");
                if ($("#other_span_endtime").attr("class") == "b4") {
                    $("#other_span_endtime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_endtime").attr("class") == "b3") {
                        $("#other_span_endtime").removeClass().addClass("b1")
                    }
                } if ($("#other_span_lishi").attr("class") == "b4") {
                    $("#other_span_lishi").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_lishi").attr("class") == "b3") {
                        $("#other_span_lishi").removeClass().addClass("b1")
                    }
                }
            }
            an = "starttime";
            au()
        });
        $("#r_time").click(function () {
            if (bG) {
                $("#r_time").removeClass().addClass("b4");
                if ($("#s_time").attr("class") == "b4") {
                    $("#s_time").removeClass().addClass("b2")
                } else {
                    if ($("#s_time").attr("class") == "b3") {
                        $("#s_time").removeClass().addClass("b1")
                    }
                } if ($("#l_s").attr("class") == "b4") {
                    $("#l_s").removeClass().addClass("b2")
                } else {
                    if ($("#l_s").attr("class") == "b3") {
                        $("#l_s").removeClass().addClass("b1")
                    }
                }
                bG = false;
                $("#other_span_starttime").removeClass().addClass("b4");
                $("#other_span_endtime").removeClass().addClass("b2");
                $("#other_span_lishi").removeClass().addClass("b2")
            } else {
                $("#r_time").removeClass().addClass("b3");
                if ($("#s_time").attr("class") == "b4") {
                    $("#s_time").removeClass().addClass("b2")
                } else {
                    if ($("#s_time").attr("class") == "b3") {
                        $("#s_time").removeClass().addClass("b1")
                    }
                } if ($("#l_s").attr("class") == "b4") {
                    $("#l_s").removeClass().addClass("b2")
                } else {
                    if ($("#l_s").attr("class") == "b3") {
                        $("#l_s").removeClass().addClass("b1")
                    }
                }
                bG = true;
                $("#other_span_endtime").removeClass().addClass("b2");
                if ($("#other_span_starttime").attr("class") == "b4") {
                    $("#other_span_starttime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_starttime").attr("class") == "b3") {
                        $("#other_span_starttime").removeClass().addClass("b1")
                    }
                } if ($("#other_span_lishi").attr("class") == "b4") {
                    $("#other_span_lishi").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_lishi").attr("class") == "b3") {
                        $("#other_span_lishi").removeClass().addClass("b1")
                    }
                }
            }
            an = "arrivedtime";
            au()
        });
        $("#other_span_endtime").click(function () {
            if (bG) {
                $("#r_time").removeClass().addClass("b4");
                if ($("#s_time").attr("class") == "b4") {
                    $("#s_time").removeClass().addClass("b2")
                } else {
                    if ($("#s_time").attr("class") == "b3") {
                        $("#s_time").removeClass().addClass("b1")
                    }
                } if ($("#l_s").attr("class") == "b4") {
                    $("#l_s").removeClass().addClass("b2")
                } else {
                    if ($("#l_s").attr("class") == "b3") {
                        $("#l_s").removeClass().addClass("b1")
                    }
                }
                bG = false;
                $("#other_span_endtime").removeClass().addClass("b4");
                if ($("#other_span_starttime").attr("class") == "b4") {
                    $("#other_span_starttime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_starttime").attr("class") == "b3") {
                        $("#other_span_starttime").removeClass().addClass("b1")
                    }
                } if ($("#other_span_lishi").attr("class") == "b4") {
                    $("#other_span_lishi").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_lishi").attr("class") == "b3") {
                        $("#other_span_lishi").removeClass().addClass("b1")
                    }
                }
            } else {
                $("#r_time").removeClass().addClass("b3");
                if ($("#s_time").attr("class") == "b4") {
                    $("#s_time").removeClass().addClass("b2")
                } else {
                    if ($("#s_time").attr("class") == "b3") {
                        $("#s_time").removeClass().addClass("b1")
                    }
                } if ($("#l_s").attr("class") == "b4") {
                    $("#l_s").removeClass().addClass("b2")
                } else {
                    if ($("#l_s").attr("class") == "b3") {
                        $("#l_s").removeClass().addClass("b1")
                    }
                }
                bG = true;
                $("#other_span_endtime").removeClass().addClass("b3");
                if ($("#other_span_starttime").attr("class") == "b4") {
                    $("#other_span_starttime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_starttime").attr("class") == "b3") {
                        $("#other_span_starttime").removeClass().addClass("b1")
                    }
                } if ($("#other_span_lishi").attr("class") == "b4") {
                    $("#other_span_lishi").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_lishi").attr("class") == "b3") {
                        $("#other_span_lishi").removeClass().addClass("b1")
                    }
                }
            }
            an = "arrivedtime";
            au()
        });
        $("#l_s").click(function () {
            if (aH) {
                $("#l_s").removeClass().addClass("b4");
                if ($("#r_time").attr("class") == "b4") {
                    $("#r_time").removeClass().addClass("b2")
                } else {
                    if ($("#r_time").attr("class") == "b3") {
                        $("#r_time").removeClass().addClass("b1")
                    }
                } if ($("#s_time").attr("class") == "b4") {
                    $("#s_time").removeClass().addClass("b2")
                } else {
                    if ($("#s_time").attr("class") == "b3") {
                        $("#s_time").removeClass().addClass("b1")
                    }
                }
                aH = false;
                $("#other_span_lishi").removeClass().addClass("b4");
                if ($("#other_span_endtime").attr("class") == "b4") {
                    $("#other_span_endtime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_endtime").attr("class") == "b3") {
                        $("#other_span_endtime").removeClass().addClass("b1")
                    }
                } if ($("#other_span_starttime").attr("class") == "b4") {
                    $("#other_span_starttime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_starttime").attr("class") == "b3") {
                        $("#other_span_starttime").removeClass().addClass("b1")
                    }
                }
            } else {
                $("#l_s").removeClass().addClass("b3");
                if ($("#r_time").attr("class") == "b4") {
                    $("#r_time").removeClass().addClass("b2")
                } else {
                    if ($("#r_time").attr("class") == "b3") {
                        $("#r_time").removeClass().addClass("b1")
                    }
                } if ($("#s_time").attr("class") == "b4") {
                    $("#s_time").removeClass().addClass("b2")
                } else {
                    if ($("#s_time").attr("class") == "b3") {
                        $("#s_time").removeClass().addClass("b1")
                    }
                }
                aH = true;
                $("#other_span_lishi").removeClass().addClass("b3");
                if ($("#other_span_endtime").attr("class") == "b4") {
                    $("#other_span_endtime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_endtime").attr("class") == "b3") {
                        $("#other_span_endtime").removeClass().addClass("b1")
                    }
                } if ($("#other_span_starttime").attr("class") == "b4") {
                    $("#other_span_starttime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_starttime").attr("class") == "b3") {
                        $("#other_span_starttime").removeClass().addClass("b1")
                    }
                }
            }
            an = "lishi";
            au()
        });
        $("#other_span_lishi").click(function () {
            if (aH) {
                $("#l_s").removeClass().addClass("b4");
                if ($("#r_time").attr("class") == "b4") {
                    $("#r_time").removeClass().addClass("b2")
                } else {
                    if ($("#r_time").attr("class") == "b3") {
                        $("#r_time").removeClass().addClass("b1")
                    }
                } if ($("#s_time").attr("class") == "b4") {
                    $("#s_time").removeClass().addClass("b2")
                } else {
                    if ($("#s_time").attr("class") == "b3") {
                        $("#s_time").removeClass().addClass("b1")
                    }
                }
                aH = false;
                $("#other_span_lishi").removeClass().addClass("b4");
                if ($("#other_span_endtime").attr("class") == "b4") {
                    $("#other_span_endtime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_endtime").attr("class") == "b3") {
                        $("#other_span_endtime").removeClass().addClass("b1")
                    }
                } if ($("#other_span_starttime").attr("class") == "b4") {
                    $("#other_span_starttime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_starttime").attr("class") == "b3") {
                        $("#other_span_starttime").removeClass().addClass("b1")
                    }
                }
            } else {
                $("#l_s").removeClass().addClass("b3");
                if ($("#r_time").attr("class") == "b4") {
                    $("#r_time").removeClass().addClass("b2")
                } else {
                    if ($("#r_time").attr("class") == "b3") {
                        $("#r_time").removeClass().addClass("b1")
                    }
                } if ($("#s_time").attr("class") == "b4") {
                    $("#s_time").removeClass().addClass("b2")
                } else {
                    if ($("#s_time").attr("class") == "b3") {
                        $("#s_time").removeClass().addClass("b1")
                    }
                }
                aH = true;
                $("#other_span_lishi").removeClass().addClass("b3");
                if ($("#other_span_endtime").attr("class") == "b4") {
                    $("#other_span_endtime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_endtime").attr("class") == "b3") {
                        $("#other_span_endtime").removeClass().addClass("b1")
                    }
                } if ($("#other_span_starttime").attr("class") == "b4") {
                    $("#other_span_starttime").removeClass().addClass("b2")
                } else {
                    if ($("#other_span_starttime").attr("class") == "b3") {
                        $("#other_span_starttime").removeClass().addClass("b1")
                    }
                }
            }
            an = "lishi";
            au()
        })
    }
    closeTrainStop = function () {
        over_flag = false;
        bF = 0;
        $("#train_stop").hide();
        $("#train_table").html("")
    };
    hideTrainStop = function (bY) {
        over_flag = false;
        if (o) {
            clearTimeout(o)
        }
        o = window.setTimeout(function () {
            if (bF != 1) {
                bF = 0;
                $("#train_stop").hide();
                $("#train_table").html("")
            }
        }, 130)
    };
    checkHover = function (bZ, bY) {
        if (getEvent(bZ).type == "mouseover") {
            return !$.contains(bY, getEvent(bZ).relatedTarget || getEvent(bZ).fromElement) && !((getEvent(bZ).relatedTarget || getEvent(bZ).fromElement) === bY)
        } else {
            return !$.contains(bY, getEvent(bZ).relatedTarget || getEvent(bZ).toElement) && !((getEvent(bZ).relatedTarget || getEvent(bZ).toElement) === bY)
        }
    };
    getEvent = function (bY) {
        return bY || window.event
    };
    checkHover = function (bZ, bY) {
        if (getEvent(bZ).type == "mouseover") {
            return !$.contains(bY, getEvent(bZ).relatedTarget || getEvent(bZ).fromElement) && !((getEvent(bZ).relatedTarget || getEvent(bZ).fromElement) === bY)
        } else {
            return !$.contains(bY, getEvent(bZ).relatedTarget || getEvent(bZ).toElement) && !((getEvent(bZ).relatedTarget || getEvent(bZ).toElement) === bY)
        }
    };
    getEvent = function (bY) {
        return bY || window.event
    };

    function bj(b0, bY) {
        for (var bZ = 0; bZ < bY.length; bZ++) {
            if (bY[bZ].key == b0) {
                return true
            }
        }
        return false
    }

    function a4(b2) {
        var b7 = function (b8) {
            this.value = b8
        };
        var b3 = new Array();
        var bZ = new Array();
        var b1 = {};
        var bY = {};
        $("#cc_from_station_name_all>ul").html("");
        $("#cc_to_station_name_all>ul").html("");
        var b0;
        var b6;
        var b5;
        for (var b4 = 0; b4 < b2.length; b4++) {
            b0 = b2[b4].queryLeftNewDTO.from_station_name;
            b6 = b2[b4].queryLeftNewDTO.to_station_name;
            b5 = b2[b4];
            if (!b1[b0]) {
                b3.push(new b7(b0));
                b1[b0] = true
            }
            if (!bY[b6]) {
                bZ.push(new b7(b6));
                bY[b6] = true
            }
        }
        $("#to_station_ul").html($.render.toStationNameTableTemplate(bZ));
        $("#from_station_ul").html($.render.stationNameTableTemplate(b3));
        $("#sear-sel-bd input[name='cc_from_station']").click(function () {
            j(bi, "cc_from_station_" + $(this).val());
            var b8 = $("input[name='cc_from_station']");
            var b9 = $("input[name='cc_from_station']:checked");
            if ($(this).is(":checked")) {
                if (b8 && b9 && b9.length == b8.length) {
                    $("#from_station_name_all").removeClass().addClass("btn-all")
                } else {
                    $("#from_station_name_all").removeClass().addClass("btn-all btn-all-sel")
                }
            } else {
                if (b8 && b9 && b9.length == 0) {
                    $("#from_station_name_all").removeClass().addClass("btn-all")
                } else {
                    $("#from_station_name_all").removeClass().addClass("btn-all btn-all-sel")
                }
            }
            au()
        });
        $("#sear-sel-bd input[name='cc_to_station']").click(function () {
            j(a7, "cc_to_station_" + $(this).val());
            var b8 = $("input[name='cc_to_station']");
            var b9 = $("input[name='cc_to_station']:checked");
            if ($(this).is(":checked")) {
                if (b8 && b9 && b9.length == b8.length) {
                    $("#to_station_name_all").removeClass().addClass("btn-all")
                } else {
                    $("#to_station_name_all").removeClass().addClass("btn-all btn-all-sel")
                }
            } else {
                if (b8 && b9 && b9.length == 0) {
                    $("#to_station_name_all").removeClass().addClass("btn-all")
                } else {
                    $("#to_station_name_all").removeClass().addClass("btn-all btn-all-sel")
                }
            }
            au()
        })
    }
    submitOrderRequest = function (bZ, bY) {
        $.ajax({
            type: "post",
            url: ctx + "login/checkUser",
            data: {},
            beforeSend: function (b0) {
                b0.setRequestHeader("If-Modified-Since", "0");
                b0.setRequestHeader("Cache-Control", "no-cache")
            }, success: function (b0) {
                var b2;
                checkusermdId = b0.attributes;
                if (b0.data.flag) {
                    if (train_tour_flag == "fc") {
                        b2 = $("#back_train_date").val()
                    } else {
                        b2 = $("#train_date").val()
                    } if (v == "0X00") {
                        var b1 = false;
                        for (i = (studentComPerArr.length - 1); i >= 0; i = i - 2) {
                            if (A(studentComPerArr[i - 1]) <= A(b2) && A(studentComPerArr[i]) >= A(b2)) {
                                b1 = true;
                                break
                            }
                        }
                        if (!b1) {
                            b("学生票的乘车时间为每年的暑假6月1日至9月30日、寒假12月1日至3月31日，目前不办理学生票业务。");
                            return
                        }
                    }
                    O(bZ, bY)
                } else {
                    bd();
                    $("#floatTable").hide();
                    a = $(window).scrollTop();
                    T(bZ, bY)
                }
            }
        })
    };

    function O(cb, b4) {
        var bY = "";
        if ($("#dc").is(":checked")) {
            bY = "dc"
        } else {
            bY = "wc"
        } if (train_tour_flag == "fc") {
            bY = "fc";
            var b1 = b4.split(":");
            var b0 = $("#back_train_date").val() + "-" + b1[0] + "-" + b1[1] + "-00";
            try {
                if (roundReferTime) {
                    if (A(roundReferTime) >= A(b0)) {
                        b("您预订的往程车票到站时间为" + A(roundReferTime).format("yyyy年MM月dd日 hh时mm分") + "，返回日期不能早于此时间");
                        return
                    }
                }
            } catch (b6) {}
        }
        if (train_tour_flag == "gc") {
            bY = "gc"
        }
        if ("undefined" == typeof (submitForm)) {
            var b2 = "secretStr=" + cb + "&train_date=" + $("#train_date").val() + "&back_train_date=" + $("#back_train_date").val() + "&tour_flag=" + bY + "&purpose_codes=" + bV() + "&query_from_station_name=" + $("#fromStationText").val() + "&query_to_station_name=" + $("#toStationText").val() + "&" + b9
        } else {
            var bZ = submitForm();
            var ca = bZ.split(":::");
            var b5 = ca[0].split(",-,")[0];
            var b8 = ca[0].split(",-,")[1];
            var b3 = ca[1].split(",-,")[0];
            var b7 = ca[1].split(",-,")[1];
            var b2 = escape(b5) + "=" + escape(b8) + "&" + b3 + "=" + b7 + "&secretStr=" + cb + "&train_date=" + $("#train_date").val() + "&back_train_date=" + $("#back_train_date").val() + "&tour_flag=" + bY + "&purpose_codes=" + bV() + "&query_from_station_name=" + $("#fromStationText").val() + "&query_to_station_name=" + $("#toStationText").val() + "&" + b9
        }
        var b9 = checkusermdId != undefined ? "&_json_att=" + encodeURIComponent(checkusermdId) : "";
        $.ajax({
            type: "post",
            url: ctx + "leftTicket/submitOrderRequest",
            data: b2,
            async: false,
            success: function (cc) {
                if (cc.status) {
                    if (cc.data == "Y") {
                        dhtmlx.alert({
                            title: "温馨提示",
                            ok: "确定",
                            text: "您选择的列车距开车时间很近了，请确保有足够的时间抵达车站，并办理换取纸质车票、安全检查、实名制验证及检票等手续，以免耽误您的旅行。",
                            type: "alert-warn",
                            callback: function () {
                                aF(bY, train_tour_flag)
                            }
                        })
                    } else {
                        aF(bY, train_tour_flag)
                    }
                }
            }
        })
    }

    function aF(bZ, bY) {
        if (bY != null) {
            if (bY == "fc") {
                otsRedirect("post", ctx + "confirmPassenger/initFc", {});
                return
            }
            if (bY == "gc") {
                otsRedirect("post", ctx + "confirmPassenger/initGc", {});
                return
            }
        }
        if (bZ == "dc") {
            otsRedirect("post", ctx + "confirmPassenger/initDc", {});
            return
        } else {
            otsRedirect("post", ctx + "confirmPassenger/initWc", {})
        }
    }
    var bU = $("#fromStation").val();
    var aX = $("#toStation").val();
    var bC = $.trim($("#train_date").val());
    aQ = bU + aX + bC;
    $("#add-train").click(function () {
        if ($("#fromStationText").val() == "简拼/全拼/汉字") {
            dhtmlx.alert({
                title: "输入车次",
                ok: "确定",
                text: "请填写出发地！",
                type: "alert-error"
            });
            return
        }
        if ($("#toStationText").val() == "简拼/全拼/汉字") {
            dhtmlx.alert({
                title: "输入车次",
                ok: "确定",
                text: "请填写目的地！",
                type: "alert-error"
            });
            return
        }
        var b0 = $("#prior_train span").length;
        var b7 = $.trim($("#inp-train").val()).toUpperCase();
        if (b7.length == 0 || b7 == "请输入") {
            dhtmlx.alert({
                title: "输入车次",
                ok: "确定",
                text: "请输入车次",
                type: "alert-error",
                callback: function () {
                    $("#inp-train").val("");
                    $("#inp-train").focus()
                }
            })
        } else {
            if (b0 < 6) {
                var b1 = /^[a-zA-Z0-9]+$/;
                var b3 = /^[0-9]+$/;
                if (!b1.test(b7)) {
                    dhtmlx.alert({
                        title: "输入车次",
                        ok: "确定",
                        text: "车次格式输入错误！",
                        type: "alert-error",
                        callback: function () {
                            ccInputSelected = true;
                            $("#inp-train").select()
                        }
                    })
                } else {
                    if (b3.test(b7) && b7.length > 4) {
                        dhtmlx.alert({
                            title: "输入车次",
                            ok: "确定",
                            text: "车次格式输入错误！",
                            type: "alert-error",
                            callback: function () {
                                ccInputSelected = true;
                                $("#inp-train").select()
                            }
                        })
                    } else {
                        if (b7.length < 2) {
                            dhtmlx.alert({
                                title: "输入车次",
                                ok: "确定",
                                text: "车次格式输入错误！",
                                type: "alert-error",
                                callback: function () {
                                    ccInputSelected = true;
                                    $("#inp-train").select()
                                }
                            })
                        } else {
                            var b2 = $("#fromStation").val();
                            var b5 = $("#toStation").val();
                            var cf = $.trim($("#train_date").val());
                            var cb = b2 + b5 + cf;
                            var cc = cf.split("-");
                            var b8 = new Date();
                            b8.setFullYear(cc[0], cc[1] - 1, cc[2]);
                            b8.setHours(8, 0, 0);
                            var b4 = new Date();
                            var ce = "";
                            ce = $.parseDateFormat(b4);
                            var bY = "";
                            if (ce == cf) {
                                var cd = new Date(b8.getTime() + 1000 * 60 * 60 * 24);
                                bY = $.parseDateFormat(cd)
                            } else {
                                bY = cf
                            }
                            var cg = {
                                "leftTicketDTO.train_date": bY,
                                "leftTicketDTO.from_station": b2,
                                "leftTicketDTO.to_station": b5,
                                purpose_codes: bV()
                            };
                            if (cb != aQ) {
                                aQ = cb;
                                $("#prior_train span:gt(0)").remove();
                                ccSelected = [];
                                var bZ = [];
                                bD(cg);
                                $.ajax({
                                    type: "get",
                                    async: false,
                                    isTakeParam: false,
                                    beforeSend: function (ch) {
                                        ch.setRequestHeader("If-Modified-Since", "0");
                                        ch.setRequestHeader("Cache-Control", "no-cache")
                                    }, url: ctx + CLeftTicketUrl,
                                    data: cg,
                                    timeout: 10000,
                                    success: function (ch) {
                                        if (ch.status) {
                                            if (ch.data == null || ch.data.length == 0) {
                                                dhtmlx.alert({
                                                    title: "错误信息",
                                                    ok: "确定",
                                                    text: "您输入的车次与出发地目的地不符！",
                                                    type: "alert-error",
                                                    callback: function () {}
                                                })
                                            } else {
                                                var cj = ch.data;
                                                for (var ci = 0; ci < cj.length; ci++) {
                                                    bZ.push(cj[ci].queryLeftNewDTO.station_train_code.toUpperCase())
                                                }
                                                D = bZ
                                            }
                                        }
                                    }
                                })
                            } else {
                                if (D.length == 0) {
                                    bD(cg);
                                    $.ajax({
                                        type: "get",
                                        async: false,
                                        isTakeParam: false,
                                        beforeSend: function (ch) {
                                            ch.setRequestHeader("If-Modified-Since", "0");
                                            ch.setRequestHeader("Cache-Control", "no-cache")
                                        }, url: ctx + CLeftTicketUrl,
                                        data: cg,
                                        timeout: 10000,
                                        success: function (ch) {
                                            if (ch.status) {
                                                if (ch.data == null || ch.data.length == 0) {
                                                    dhtmlx.alert({
                                                        title: "错误信息",
                                                        ok: "确定",
                                                        text: "您输入的车次与出发地目的地不符！",
                                                        type: "alert-error",
                                                        callback: function () {}
                                                    })
                                                } else {
                                                    var cj = ch.data;
                                                    for (var ci = 0; ci < cj.length; ci++) {
                                                        D.push(cj[ci].queryLeftNewDTO.station_train_code.toUpperCase())
                                                    }
                                                }
                                            }
                                        }
                                    })
                                }
                            }
                            var b6 = false;
                            for (var ca = 0; ca < D.length; ca++) {
                                if (b7 == D[ca]) {
                                    b6 = true;
                                    break
                                }
                            }
                            if (!b6) {
                                dhtmlx.alert({
                                    title: "错误信息",
                                    ok: "确定",
                                    text: "您输入的车次与出发地目的地不符！",
                                    type: "alert-error",
                                    callback: function () {
                                        $("#inp-train").val("")
                                    }
                                })
                            } else {
                                if ($.inArray(b7, ccSelected) < 0) {
                                    var b9 = "<span class='sel-box w80'>" + b7 + "<a class='close' href='javascript:' onclick='$.removeSel(this,\"" + b7 + "\",4)'></a></span>";
                                    $("#prior_train").append(b9);
                                    ccSelected.push(b7);
                                    $("#inp-train").val("")
                                } else {
                                    dhtmlx.alert({
                                        title: "输入车次",
                                        ok: "确定",
                                        text: "此车次已经添加过！",
                                        type: "alert-error",
                                        callback: function () {
                                            ccInputSelected = true;
                                            $("#inp-train").select()
                                        }
                                    })
                                }
                            }
                        }
                    }
                }
            } else {
                dhtmlx.alert({
                    title: "输入车次",
                    ok: "确定",
                    text: "最多添加5个优先车次",
                    type: "alert-error"
                });
                $("#inp-train").val("")
            }
        }
    });

    function bV() {
        if ($("#sf2").is(":checked")) {
            return "0X00"
        } else {
            return "ADULT"
        }
    }
    jQuery.extend({
        init_ul4li: function () {
            var bY = [];
            var b0 = 0;
            bY[b0++] = '<li><input name="cc_type" value="G" type="checkbox" class="check" /><label for="">GC-高铁/城际</label></li>';
            bY[b0++] = '<li><input name="cc_type" value="D" type="checkbox" class="check" /><label for="">D-动车</label></li>';
            bY[b0++] = '<li><input name="cc_type" value="Z" type="checkbox" class="check" /><label for="">Z-直达</label></li>';
            bY[b0++] = '<li><input name="cc_type" value="T" type="checkbox" class="check" /><label for="">T-特快</label></li>';
            bY[b0++] = '<li><input name="cc_type" value="K" type="checkbox" class="check" /><label for="">K-快速</label></li>';
            bY[b0++] = '<li><input name="cc_type" value="QT" type="checkbox" class="check" /><label for="">其他</label></li>';
            $("#_ul_station_train_code").html(bY.join(""));
            if (train_tour_flag == "gc" && "Y" == isDwTicketResign) {
                var b2 = $("#_ul_station_train_code li");
                for (var bZ = 2, b1 = b2.length; bZ < b1; bZ++) {
                    b2.eq(bZ).find("input").attr("disabled", "disabled");
                    b2.eq(bZ).find("label").attr("for", "").attr("style", "color: rgb(153, 153, 153)")
                }
            }
            $("#startendtime").html('<span class="b1" id="s_time">出发时间</span><br /><span class="b2" id="r_time">到达时间</span>');
            $("#floatstartendtime").html('<span class="b1" id="other_span_starttime">出发时间</span><br /><span class="b2" id="other_span_endtime">到达时间</span>')
        }, parseDateFormat: function (b2) {
            var bY = "";
            var bZ = b2.getFullYear();
            var b1 = b2.getMonth() + 1;
            var b0 = b2.getDate();
            if (b1 < 10) {
                b1 = "0" + b1
            }
            if (b0 < 10) {
                b0 = "0" + b0
            }
            bY = bZ + "-" + b1 + "-" + b0;
            return bY
        }, renderPassenger: function () {
            if (passengerAll) {
                var ca = passengerAll.length;
                var b6 = [];
                var b4 = 0;
                var bZ = $("#searchPassenger").val();
                for (var b2 = 0; b2 < ca; b2++) {
                    var b0 = passengerAll[b2];
                    var bY = b0.passenger_type_name;
                    if (!bY) {
                        bY = ""
                    }
                    var b3 = "";
                    var b5 = "";
                    if ($("#sf2").is(":checked")) {
                        if (b0.passenger_type != "3") {
                            b3 = " disabled='true' ";
                            b5 = " class='color999' "
                        }
                    }
                    var b8 = b0.total_times;
                    if (b0.passenger_id_type_code == "2") {
                        b3 = " disabled='true' ";
                        b5 = " class='color999' title='请修改身份信息' "
                    } else {
                        if (b0.passenger_id_type_code == "1") {
                            if (!isCanGP("1", b8)) {
                                b3 = " disabled='true' ";
                                b5 = " class='color999' title='请修改身份信息' "
                            }
                        } else {
                            if (!isCanGP("B", b8)) {
                                b3 = " disabled='true' ";
                                b5 = " class='color999' title='请修改身份信息' "
                            }
                            if (!isCanGP("H", b8)) {
                                b3 = " disabled='true' ";
                                b5 = " class='color999' title='请修改身份信息' "
                            }
                        }
                    } if (bZ != "" && bZ != "输入乘客姓名") {
                        if (b0.passenger_name.indexOf(bZ) > -1 || (b0.first_letter && b0.first_letter.toUpperCase().indexOf(bZ.toUpperCase()) > -1)) {
                            b4++;
                            var b1 = "";
                            if ($.pHasInSelected(b0)) {
                                b1 = " checked='checked' "
                            }
                            b6[b2] = "<li " + b5 + "><input " + b1 + " type='checkbox' " + b3 + " name='" + b0.passenger_type + "' codeType='" + b0.passenger_id_type_code + "' flag='" + b0.total_times + "' class='check' />" + b0.passenger_name + "(" + bY + ")(" + b0.passenger_id_no + ")</li>"
                        }
                    } else {
                        b4++;
                        var b1 = "";
                        if ($.pHasInSelected(b0)) {
                            b1 = " checked='checked' "
                        }
                        b6[b2] = "<li " + b5 + "><input  " + b1 + " type='checkbox' " + b3 + " name='" + b0.passenger_type + "' codeType='" + b0.passenger_id_type_code + "' flag='" + b0.total_times + "' class='check' />" + b0.passenger_name + "(" + bY + ")(" + b0.passenger_id_no + ")</li>"
                    }
                }
                var b9 = 100;
                var b7 = 0;
                if (b4 / 3 > 11) {
                    b9 = 310;
                    b7 = 258
                } else {
                    b9 = 100 + parseInt((b4 / 3) * 25);
                    b7 = b9 - 48
                }
                $("#sel-buyer").css("height", b9);
                $("#pContent").css("height", b7);
                $("#buyer-list").html(b6.join(""))
            }
            $("#buyer-list input").click(function () {
                var cd = $("#setion_postion span").length;
                var cf = this.nextSibling.nodeValue;
                if (this.checked) {
                    if (cd < 6) {
                        var cb = "";
                        var cc = true;
                        if (cf.indexOf("成人") > -1) {
                            cb = "<span name='" + cf + "' class='sel-box w80'><a href='javascript:' onclick='$.addChildPassenger(\"" + cf + "\");' style='position:static;background:none;width:auto;' title='您可点击此乘车人添加儿童票。'>" + cf + "</a><a class='close' href='javascript:' onclick='$.removeSel(this,\"" + cf + "\",1)'></a></span>";
                            $("#setion_postion").append(cb);
                            $.checkedPasseanger(cf)
                        } else {
                            if (cf.indexOf("学生") > -1) {
                                var ce = $(this);
                                if ($.checkSeatTypes()) {
                                    cb = "<span name='" + cf + "' class='sel-box w80'>" + cf + "<a class='close' href='javascript:' onclick='$.removeSel(this,\"" + cf + "\",1)'></a></span>";
                                    $("#setion_postion").append(cb);
                                    $.checkedPasseanger(cf)
                                } else {
                                    $("#conifrmdialog_student_to_adult_context").html("当前选择的优先席别有不支持学生票的，是否选择购买成人票？");
                                    dhtmlx.createWin({
                                        winId: "confirmChangeStudentToAdult",
                                        closeWinId: ["close_conifrmdialog_student_to_adult", "cancel_dialog_student_to_adult"],
                                        callback: function () {
                                            $(ce).prop("checked", false)
                                        }, okId: "goto_student_to_adult",
                                        okCallBack: function () {
                                            var cg = cf.replace(/学生/, "成人");
                                            cb = "<span name='" + cf + "' class='sel-box w80'>" + cg + "<a class='close' href='javascript:' onclick='$.removeSel(this,\"" + cf + "\",1)'></a></span>";
                                            $("#setion_postion").append(cb);
                                            $.checkedPasseanger(cg)
                                        }
                                    })
                                }
                            } else {
                                if (cf.indexOf("儿童") > -1) {
                                    cb = "<span name='" + cf + "' class='sel-box w80' title='如需修改旅客类型，请修改相应常用联系人信息。'>" + cf + "<a class='close' href='javascript:' onclick='$.removeSel(this,\"" + cf + "\",1)'></a></span>";
                                    $("#setion_postion").append(cb);
                                    $.checkedPasseanger(cf)
                                } else {
                                    cb = "<span name='" + cf + "' class='sel-box w80'>" + cf + "<a class='close' href='javascript:' onclick='$.removeSel(this,\"" + cf + "\",1)'></a></span>";
                                    $("#setion_postion").append(cb);
                                    $.checkedPasseanger(cf)
                                }
                            }
                        }
                    } else {
                        dhtmlx.alert({
                            title: "添加常用联系人",
                            ok: "确定",
                            text: "最多添加5位联系人",
                            type: "alert-error"
                        });
                        this.checked = false
                    }
                } else {
                    $.each($("#setion_postion span"), function (cg, ch) {
                        if (cf == $(ch).attr("name")) {
                            $(ch).remove();
                            $.removePasseanger(cf);
                            return
                        }
                    })
                }
            })
        }, reloadPassenger: function () {
            var bY = dhtmlx.modalbox({
                targSrc: '<div><img src="' + ctx + 'resources/images/loading.gif"></img></div>',
                callback: function () {}
            });
            $.ajax({
                type: "post",
                isTakeParam: false,
                cache: false,
                async: false,
                url: ctx + "confirmPassenger/getPassengerDTOs",
                timeout: 10000,
                error: function (bZ, b1, b0) {
                    dhtmlx.modalbox.hide(bY)
                }, success: function (bZ) {
                    dhtmlx.modalbox.hide(bY);
                    if (bZ.status) {
                        if (bZ.data.noLogin == "true") {
                            bd();
                            $("#floatTable").hide();
                            a = $(window).scrollTop();
                            S()
                        } else {
                            if (bZ.data.exMsg != "" && bZ.data.exMsg != null && bZ.data.exMsg != "null") {
                                b(bZ.data.exMsg);
                                return
                            }
                            $("#sel-buyer").show();
                            $("#sel-seat").hide();
                            $("#sel-date").hide();
                            $("#sel-buyer").css("left", $("#sear-sel").position().left + 80);
                            $("#sel-buyer").css("left", $("#sear-sel").position().left + 80);
                            $("#sel-buyer").css("top", $("#sear-sel").position().top + 4 * 28 + 16);
                            passengerAll = bZ.data.normal_passengers;
                            if (!(passengerAll && passengerAll.length > 0)) {
                                passengerAll = []
                            }
                            var b2 = bZ.data.dj_passengers;
                            if (b2 && b2.length > 0) {
                                var b1 = b2.length;
                                for (var b0 = 0; b0 < b1; b0++) {
                                    if (!$.checkIsHas(passengerAll, b2[b0])) {
                                        passengerAll.push(b2[b0])
                                    }
                                }
                            }
                            two_isOpenClick = bZ.data.two_isOpenClick;
                            other_isOpenClick = bZ.data.other_isOpenClick;
                            $.renderPassenger()
                        }
                    }
                }
            })
        }, checkIsHas: function (b0, b1) {
            var bZ = b0.length;
            for (var bY = 0; bY < bZ; bY++) {
                if (b0[bY].passenger_name == b1.passenger_name && b0[bY].passenger_id_type_code == b1.passenger_id_type_code && b1.passenger_id_no == b0[bY].passenger_id_no) {
                    return true
                }
            }
            return false
        }, pHasInSelected: function (b1) {
            var bZ = passengerChecked.length;
            if (bZ > 0) {
                for (var bY = 0; bY < bZ; bY++) {
                    var b0 = passengerChecked[bY];
                    if (b0.passenger_name == b1.passenger_name && b0.passenger_id_type_code == b1.passenger_id_type_code && b0.passenger_id_no == b1.passenger_id_no) {
                        return true
                    }
                }
            }
            return false
        }, showSelectBuyer: function () {
            if (!passengerAll) {
                $.reloadPassenger()
            } else {
                var bY = $("#buyer-list input");
                for (var bZ = 0; bZ < bY.length; bZ++) {
                    var b1 = $(bY[bZ]).attr("name");
                    var b0 = $(bY[bZ]).attr("codeType");
                    var b2 = $(bY[bZ]).attr("flag");
                    if ($("#sf2").is(":checked")) {
                        if (b1 != "3") {
                            $(bY[bZ]).attr("disabled", "true");
                            $(bY[bZ]).parent().addClass("color999")
                        } else {
                            $(bY[bZ]).removeAttr("disabled");
                            $(bY[bZ]).parent().removeClass("color999")
                        }
                    } else {
                        $(bY[bZ]).removeAttr("disabled");
                        $(bY[bZ]).parent().removeClass("color999")
                    } if (b0 == "2") {
                        $(bY[bZ]).attr("disabled", "true");
                        $(bY[bZ]).parent().addClass("color999")
                    } else {
                        if (b0 == "1") {
                            if (!isCanGP("1", b2)) {
                                $(bY[bZ]).attr("disabled", "true");
                                $(bY[bZ]).parent().addClass("color999")
                            }
                        } else {
                            if (!isCanGP("B", b2)) {
                                $(bY[bZ]).attr("disabled", "true");
                                $(bY[bZ]).parent().addClass("color999")
                            }
                            if (!isCanGP("H", b2)) {
                                $(bY[bZ]).attr("disabled", "true");
                                $(bY[bZ]).parent().addClass("color999")
                            }
                        }
                    }
                }
                $("#sel-buyer").show();
                $("#sel-seat").hide();
                $("#sel-date").hide();
                $("#sel-buyer").css("left", $("#sear-sel").position().left + 80);
                $("#sel-buyer").css("top", $("#sear-sel").position().top + 4 * 28 + 16)
            }
        }, getMindateForCal: function () {
            if ($("#sf2").is(":checked")) {
                g = studentMindate
            } else {
                g = otherMindate
            }
            return g
        }, getMaxdateForCal: function () {
            if ($("#sf2").is(":checked")) {
                B = studentMaxdate
            } else {
                B = otherMaxdate
            }
            return B
        }
    });

    function C() {
        $("#show_all_query_result").click(function () {
            bi = new Array();
            a7 = new Array();
            J = new Array();
            $("#train_type_btn_all").removeClass().addClass("btn-all");
            $("#start_time_btn_all").removeClass().addClass("btn-all");
            $("#arrive_time_btn_all").removeClass().addClass("btn-all");
            $("#seat_type_btn_all").removeClass().addClass("btn-all");
            $("#from_station_name_all").removeClass().addClass("btn-all");
            $("#to_station_name_all").removeClass().addClass("btn-all");
            $("#sear-sel-bd input").each(function () {
                if (this.checked) {
                    this.checked = false
                }
            });
            if (am) {
                am.setComboText("")
            }
            $("#avail_ticket").attr("checked", false);
            au()
        })
    }

    function ai() {
        var bY = $("#queryPriceTemplate").html().replace("<!--", "").replace("-->", "");
        $.templates({
            priceTableTemplate: bY
        });
        var bY = $("#fromStationNameTemplate").html().replace("<!--", "").replace("-->", "");
        $.templates({
            stationNameTableTemplate: bY
        });
        var bY = $("#toStationNameTemplate").html().replace("<!--", "").replace("-->", "");
        $.templates({
            toStationNameTableTemplate: bY
        });
        var bY = $("#seatTypeTemplate").html().replace("<!--", "").replace("-->", "");
        $.templates({
            seatTypeTemplate: bY
        });
        var bY = $("#stationinfoTemplate").html().replace("<!--", "").replace("-->", "");
        $.templates({
            stationinfoTemplate: bY
        })
    }

    function bm(bZ) {
        dhtmlXCombo_defaultOption.prototype._DrawHeaderButton = function () {};
        $("#train_combo_box").hide();
        var bY = [];
        if (!am) {
            am = new dhtmlXCombo("train_combo_box_div", "cc", 90)
        } else {
            am.setComboText("")
        }
        am.clearAll();
        $(bZ).each(function () {
            bY.push([this.queryLeftNewDTO.station_train_code, this.queryLeftNewDTO.station_train_code])
        });
        am.addOption(bY);
        am.enableFilteringMode(true);
        am.attachEvent("onChange", function () {
            if (am.getComboText() != "") {
                if ($("#iLcear").is(":hidden")) {
                    $("#iLcear").show()
                }
            }
            au()
        });
        if (!$("#iLcear")[0]) {
            $(".dhx_combo_box ").append($('<span style="display: none;" class="i-clear dhx_combo_img_iClear" id="iLcear"></span>'));
            $("#iLcear").on("click", function () {
                if (am) {
                    am.setComboText("");
                    $(this).hide()
                }
            })
        }
        $(".dhx_combo_input").on("keyup", function () {
            if ($(this).val() == "") {
                $("#iLcear").hide()
            } else {
                if ($("#iLcear").is(":hidden")) {
                    $("#iLcear").show()
                }
            }
        })
    }

    function ah() {
        if (!bM) {
            bM = new dhtmlXWindows();
            bM.enableAutoViewport(true);
            bM.setSkin("dhx_terrace");
            bM.attachViewportTo("winVP");
            bM.setImagePath(ctx + "resources/js/rich/windows/imgs/")
        }
    }

    function bb() {
        bM.window("login").hide();
        bM.window("login").setModal(false)
    }

    function bd() {
        if (bM.window("login")) {
            bM.window("login").setModal(false);
            bM.window("login").hide()
        }
        aL = bM.createWindow("login", 0, 0, 400, 350);
        var bY, bZ;
        if (TouLocal.checkZByTargeElement("")) {
            bY = $(window).width() / 2 - 208;
            bZ = bR() + ($(window).height() / 2 - 232)
        } else {
            bY = $(window).width() / 2 - 200;
            bZ = bR() + ($(window).height() / 2 - 205)
        }
        aL.attachObject("relogin");
        aL.setDimension($("#content").width(), $("#content").height() + 10);
        $(".dhtmlx_window_active").height($("#content").height());
        $(".dhtmlx_window_active").css({
            left: bY,
            top: bZ
        });
        aL.bringToTop();
        bM.window("login").clearIcon();
        bM.window("login").denyResize();
        aL.button("park").hide();
        aL.button("minmax1").hide();
        aL.hideHeader();
        refreshImg("login", "sjrand");
        aL.setModal(true);
        $("#relogin_close").click(function () {
            a1();
            var b0 = $(window).scrollTop();
            var b1 = $("#float").position().top;
            if (b0 > b1 + 30) {
                $("#floatTable").show()
            }
            bb()
        });
        if (typeof (touclickHook_leftTicketLogin) === "function") {
            touclickHook_leftTicketLogin()
        }
    }

    function a1() {
        aB();
        $("#username").val("");
        $("#password").val("");
        $("#randCode").val("");
        bH()
    }

    function bR() {
        if ("pageYOffset" in window) {
            return window.pageYOffset
        } else {
            if (document.compatMode == "BackCompat") {
                return document.body.scrollTop
            } else {
                return document.documentElement.scrollTop
            }
        }
    }

    function aB() {
        $("#username").add($("#password")).add($("#randCode")).add($("#randCode2")).removeClass("error")
    }

    function z(b2) {
        var bZ = /^(13[0-9])|(14[0-9])|(15[0-9])|(18[0-9])|(17[0-9])\d{8}$/;
        var bY = /^[A-Za-z]{1}([A-Za-z0-9]|[_]){0,29}$/;
        var b1 = /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))$/i;
        var b0 = true;
        aB();
        if ("" == b2 || b2 == null || b2 == uninputmsg || b2 == "admin") {
            $("#username").removeClass("inptxt w200").addClass("inptxt w200 error");
            b0 = login_messages.userNameEmpty
        } else {
            if (!bY.test(b2) && !b1.test(b2) && !bZ.test(b2)) {
                $("#username").removeClass("inptxt w200").addClass("inptxt w200 error");
                b0 = login_messages.userNameFormat
            }
        }
        return b0
    }

    function bf(bY) {
        var bZ = true;
        aB();
        if ("" == bY || bY == null) {
            $("#password").removeClass("inptxt w200").addClass("inptxt w200 error");
            bZ = login_messages.passwordEmpty
        } else {
            if (bY.length < 6) {
                $("#password").removeClass("inptxt w200").addClass("inptxt w200 error");
                bZ = login_messages.passwordLength
            }
        }
        return bZ
    }

    function aD() {
        var b0 = $.trim($("#username").val());
        var bY = $.trim($("#password").val());
        var bZ = z(b0);
        return typeof (bZ) === "boolean" ? bf(bY) : bZ
    }

    function y() {
        var bZ = false;
        var bY = false;
        $("#username").on("keyup", function () {
            aq = true
        }).blur(function () {
            if (aq) {
                var b0 = $.trim($("#username").val());
                bZ = z(b0);
                if (typeof (bZ) !== "boolean") {
                    showError($("#randCode")[0], bZ)
                } else {
                    if (bZ === true) {
                        showError($("#randCode")[0]).hide()
                    }
                }
            }
        });
        $("#password").blur(function () {
            if (aq) {
                var b0 = $.trim($("#password").val());
                if (bZ === true && typeof (bY = bf(b0)) !== "boolean") {
                    showError($("#randCode")[0], bY)
                } else {
                    if (bZ === true && bY === true) {
                        showError($("#randCode")[0]).hide()
                    }
                }
            }
        })
    }

    function T(bZ, bY) {
        $("#loginSubAsyn").unbind("click");
        $("#loginSubAsyn").click(function () {
            var b0 = aD();
            if (!verifyRandCode($("#randCode")[0], b0)) {
                return
            }
            $("#loginForm").ajaxSubmit({
                url: ctx + "login/loginUserAsyn?random=" + new Date().getTime(),
                type: "post",
                dataType: "json",
                async: false,
                success: function (b1) {
                    if (b1.data.status) {
                        if (b1.data.username != null) {
                            bb();
                            loginAsyn(b1.data.username);
                            if (b1.data.otherMsg != "") {
                                dhtmlx.alert({
                                    title: messages["message.error"],
                                    ok: messages["button.ok"],
                                    text: b1.data.otherMsg,
                                    type: "alert-error",
                                    callback: function () {
                                        if ("Y" == b1.data.notifysession) {
                                            dhtmlx.createWin({
                                                winId: "notifysession",
                                                closeWinId: ["close_notifysession"],
                                                okId: "goto_notifysession",
                                                okCallBack: function () {
                                                    O(bZ, bY)
                                                }
                                            })
                                        } else {
                                            O(bZ, bY)
                                        }
                                    }
                                })
                            } else {
                                if ("Y" == b1.data.notifysession) {
                                    dhtmlx.createWin({
                                        winId: "notifysession",
                                        closeWinId: ["close_notifysession"],
                                        okId: "goto_notifysession",
                                        okCallBack: function () {
                                            O(bZ, bY)
                                        }
                                    })
                                } else {
                                    O(bZ, bY)
                                }
                            }
                        }
                    } else {
                        showSuc($("#randCode")[0]).hide();
                        refreshImg("login", "sjrand");
                        $("#password").val("");
                        $("#randCode").val("");
                        if (b1.data.loginFail != null) {
                            if (b1.data.loginFail == "登录名不存在!") {
                                aq = false;
                                aB();
                                $("#username").removeClass("error").focus()
                            } else {
                                if (b1.data.loginFail == "验证码不正确！" && b1.data.loginFail != "登录名不存在!") {
                                    aB();
                                    $("#randCode").removeClass("inptxt w100").addClass("inptxt w200 error");
                                    $("#randCode").focus()
                                } else {
                                    if (b1.data.loginFail != "验证码不正确！" && b1.data.loginFail != "登录名不存在!") {
                                        aB();
                                        $("#password").removeClass("inptxt w200").addClass("inptxt w200 error");
                                        $("#password").focus()
                                    }
                                }
                            }
                            showError($("#randCode")[0], b1.data.loginFail)
                        }
                    }
                }
            })
        })
    }

    function S() {
        var bY = false;
        $("#loginSubAsyn").unbind("click");
        $("#loginSubAsyn").click(function () {
            if (!bY) {
                var bZ = aD();
                if (!verifyRandCode($("#randCode")[0], bZ)) {
                    bY = false;
                    return
                }
                bY = true;
                $("#loginForm").ajaxSubmit({
                    url: ctx + "login/loginUserAsyn?random=" + new Date().getTime(),
                    type: "post",
                    dataType: "json",
                    async: false,
                    success: function (b0) {
                        if (b0.data.status) {
                            if (b0.data.otherMsg != "") {
                                dhtmlx.alert({
                                    title: messages["message.error"],
                                    ok: messages["button.ok"],
                                    text: b0.data.otherMsg,
                                    type: "alert-error",
                                    callback: function () {
                                        if (b0.data.username != null) {
                                            bb();
                                            loginAsyn(b0.data.username)
                                        }
                                    }
                                })
                            } else {
                                if (b0.data.username != null) {
                                    bb();
                                    loginAsyn(b0.data.username)
                                }
                            }
                        } else {
                            $("#i-ok").hide();
                            refreshImg("login", "sjrand");
                            $("#password").val("");
                            $("#randCode").val("");
                            if (b0.data.loginFail != null) {
                                if (b0.data.loginFail == "登录名不存在!") {
                                    aq = false;
                                    aB();
                                    $("#username").removeClass("inptxt w200").addClass("inptxt w200 error");
                                    $("#username").focus()
                                } else {
                                    if (b0.data.loginFail == "验证码不正确！" && b0.data.loginFail != "登录名不存在!") {
                                        aB();
                                        $("#randCode").removeClass("inptxt w100").addClass("inptxt w200 error");
                                        $("#randCode").focus()
                                    } else {
                                        if (b0.data.loginFail != "验证码不正确！" && b0.data.loginFail != "登录名不存在!") {
                                            aB();
                                            $("#password").removeClass("inptxt w200").addClass("inptxt w200 error");
                                            $("#password").focus()
                                        }
                                    }
                                }
                                showError($("#randCode")[0], b0.data.loginFail)
                            }
                        }
                    }, complete: function () {
                        bY = false
                    }
                })
            }
        })
    }

    function aG() {
        window.sucessCallback = function () {
            bg = $("#randCode2").val();
            $("#back_edit").trigger("click");
            var bY = "99999GGGGG";
            var b0 = "##CCT##PPT##CPT##PXT##SBT##PBD##JOD##HPD##SHD##QTP##TSP##TJP##";
            var bZ = "##CBP##DIP##JGK##ZEK##UUH##NKH##ESH##OHH##AOH##";
            if (isAsync == ticket_submit_order.request_flag.isAsync) {
                if (G.queryLeftNewDTO.train_no.indexOf(bY) > -1 && b0.indexOf(G.queryLeftNewDTO.from_station_telecode) > -1 && bZ.indexOf(G.queryLeftNewDTO.to_station_telecode) > -1) {
                    dhtmlx.createWin({
                        winId: "confirmG1234",
                        closeWinId: ["close_conifrmdialog_G1234", "cancel_dialog_G1234"],
                        okId: "goto_integration_G1234",
                        okCallBack: function () {
                            p()
                        }, callback: function () {
                            return
                        }
                    })
                } else {
                    p()
                }
            } else {
                if (G.queryLeftNewDTO.train_no.indexOf(bY) > -1 && b0.indexOf(G.queryLeftNewDTO.from_station_telecode) > -1 && bZ.indexOf(G.queryLeftNewDTO.to_station_telecode) > -1) {
                    dhtmlx.createWin({
                        winId: "confirmG1234",
                        closeWinId: ["close_conifrmdialog_G1234", "cancel_dialog_G1234"],
                        okId: "goto_integration_G1234",
                        okCallBack: function () {
                            bX()
                        }, callback: function () {
                            return
                        }
                    })
                } else {
                    bX()
                }
            }
            return
        }
    }

    function bH() {
        $("#username").css("color", "#333");
        $("#password").css("color", "#333");
        $("#randCode").css("color", "#333");
        if ($("#username").val() == "" || $("#username").val() == uninputmsg || $("#username").val() == null || $("#username").val() == "admin") {
            $("#username").css("color", "#999");
            $("#username").val(uninputmsg);
            $("#password").val("")
        }
        $("#username").focus(function () {
            var bY = $("#username").val();
            if (bY == uninputmsg) {
                $("#username").css("color", "#333");
                $("#username").val("");
                $("#password").val("")
            }
        }).blur(function () {
            var bY = $("#username").val();
            if (bY == "") {
                $("#username").css("color", "#999");
                $("#username").val(uninputmsg)
            }
        })
    }

    function Y() {
        $("#forget_my_password_id").on("click", function (bY) {
            otsRedirect("post", ctx + "forgetPassword/initforgetMyPassword")
        })
    }

    function aE() {
        var bY = 1;
        var b4;
        var b9;
        var b0;
        var b3 = true;
        var b2 = true;
        var b7 = true;
        var cb;
        var bZ;
        var b8 = false;
        var b5 = false;
        var ca = false;
        b0 = dataNumber;
        var b6;
        if (train_tour_flag != null && train_tour_flag != "" && train_tour_flag == "fc") {
            b6 = jQuery.inArray($("#back_train_date").val().substring(5, 10), change_dates_arr)
        } else {
            b6 = jQuery.inArray($("#train_date").val().substring(5, 10), change_dates_arr)
        } if (b6 != "-1") {
            b6 = b6 + 1;
            cb = firstShow;
            bZ = endShow;
            if (parseInt(b6) >= parseInt(firstShow) && parseInt(b6) <= parseInt(endShow)) {
                if (isOther) {
                    if (parseInt(endShow) > parseInt(other_control)) {
                        endShow = other_control;
                        b5 = true;
                        b8 = true
                    }
                } else {
                    if (parseInt(endShow) > parseInt(stu_control)) {
                        endShow = stu_control
                    }
                } if (!b5) {
                    b3 = false;
                    b2 = false;
                    b7 = false;
                    b9 = endShow + 1
                }
            } else {
                b8 = true;
                firstShow = b6;
                endShow = firstShow + 19;
                if (isOther) {
                    if (parseInt(endShow) > parseInt(other_control)) {
                        endShow = other_control;
                        b5 = true
                    }
                } else {
                    if (parseInt(endShow) > parseInt(stu_control)) {
                        endShow = stu_control;
                        b5 = true
                    }
                } if (!b5) {
                    b4 = firstShow - 1;
                    b9 = endShow + 1;
                    if (b4 < bY) {
                        b3 = false
                    }
                }
            } if (isOther) {
                if (other_control < dataNumber) {
                    ca = true
                }
            } else {
                if (stu_control < dataNumber) {
                    ca = true
                }
            } if (b5) {
                b8 = true;
                firstShow = endShow - 19;
                b4 = firstShow - 1;
                if (ca) {
                    b2 = true;
                    b9 = endShow + 1;
                    b0 = dataNumber
                } else {
                    b2 = false
                } if (train_tour_flag != null && train_tour_flag != "" && train_tour_flag == "fc") {
                    $("#back_train_date").val(fullDateArr[b6 - 1])
                } else {
                    $("#train_date").val(fullDateArr[b6 - 1])
                }
            }
            if (parseInt(firstShow) < 1) {
                firstShow = 1
            }
            if (b3) {
                for (var b1 = bY; b1 <= b4; b1++) {
                    $("#date_range>ul>li:nth-child(" + b1 + ")").hide()
                }
            }
            if (b2) {
                for (var b1 = b9; b1 <= b0; b1++) {
                    $("#date_range>ul>li:nth-child(" + b1 + ")").hide()
                }
            }
            if (b7) {
                for (var b1 = firstShow; b1 <= endShow; b1++) {
                    $("#date_range>ul>li:nth-child(" + b1 + ")").show()
                }
            }
            $("#date_range>ul>li").removeClass("sel");
            if (b8) {
                $("#date_range>ul>li:nth-child(" + cb + ")").children("span:first").removeClass();
                $("#date_range>ul>li:nth-child(" + cb + ")").children("span:last").removeClass();
                $("#date_range>ul>li:nth-child(" + bZ + ")").removeClass();
                $("#date_range>ul>li:nth-child(" + firstShow + ")").children("span:first").addClass("first");
                $("#date_range>ul>li:nth-child(" + firstShow + ")").children("span:last").addClass("first");
                $("#date_range>ul>li:nth-child(" + firstShow + ")").children().addClass("first");
                $("#date_range>ul>li:nth-child(" + endShow + ")").addClass("end")
            }
            $("#date_range>ul>li:nth-child(" + b6 + ")").addClass("sel");
            $("#date_range>ul>li:nth-child(" + b6 + ")").children("span:last-child").removeClass();
            $("#date_range>ul>li:nth-child(" + b6 + ")").children("span:first-child").addClass("hide");
            bx = $("#date_range>ul>li:nth-child(" + b6 + ")").children("span:first-child").text()
        }
    }

    function bt() {
        $("#query_ticket").unbind("click");
        $("#query_ticket_stu").unbind("click");
        $("#query_ticket").removeClass().addClass("btn92s btn-disabled");
        $("#query_ticket_stu").removeClass().addClass("btn92s btn-disabled");
        a3();
        setTimeout(function () {
            bW();
            a0();
            $("#query_ticket").removeClass().addClass("btn92s");
            $("#query_ticket_stu").removeClass().addClass("btn92s");
            if (train_tour_flag != "gc" && train_tour_flag != "fc") {
                if (ClickWho == "0X00") {
                    $("#query_ticket").unbind();
                    $("#query_ticket").removeClass().addClass("btn92s btn-disabled");
                    $("#query_ticket_stu").removeClass().addClass("btn92s")
                }
                if (ClickWho == "00") {
                    $("#query_ticket_stu").unbind();
                    $("#query_ticket_stu").removeClass().addClass("btn92s btn-disabled");
                    $("#query_ticket").removeClass().addClass("btn92s")
                }
            }
            if (isstudentDate) {
                $("#query_ticket_stu").unbind();
                $("#query_ticket_stu").removeClass().addClass("btn92s btn-disabled");
                $("#query_ticket").removeClass().addClass("btn92s")
            }
        }, 1000)
    }
    changeArriveDate = function (bZ, bY) {
        bZ = bZ.replace(":", "");
        bY = bY.replace(":", "");
        hour_value = Number(bZ.substring(0, 2)) + Number(bY.substring(0, 2));
        min_value = Number(bZ.substring(2, 4)) + Number(bY.substring(2, 4));
        if (min_value >= 60) {
            hour_value = hour_value + 1
        }
        if (hour_value >= 24 && hour_value < 48) {
            return "次日"
        } else {
            if (hour_value >= 48 && hour_value < 72) {
                return "两日"
            } else {
                if (hour_value >= 72) {
                    return "三日"
                } else {
                    return "当日"
                }
            }
        }
    };
    changeLiShi = function (bY) {
        if (bY.substring(0, 1) == "0") {
            if (bY.substring(1, 2) == "0") {
                if (bY.substring(3, 4) == "0") {
                    bY = bY.substring(4, 5) + "分"
                } else {
                    bY = bY.substring(3, 5) + "分"
                }
            } else {
                bY = bY.substring(1, 2) + "小时" + bY.substring(3, 5) + "分"
            }
        } else {
            if (bY.substring(3, 5) == "00") {
                bY = bY.substring(0, 2) + "小时"
            } else {
                bY = bY.substring(0, 2) + "小时" + bY.substring(3, 5) + "分"
            }
        }
        return bY
    };
    isNum = function (bY) {
        return parseInt(bY)
    };
    buttonText = function () {
        return "预订"
    };

    function ae() {
        if ($("#sf2").is(":checked")) {
            if (A($("#train_date").val()) > A(init_maxPeriod) - 24 * 60 * 60 * 1000) {
                a3()
            } else {
                a0()
            }
        }
    }

    function af() {
        if (train_tour_flag == "fc") {
            var bY = $("#back_train_date").val();
            x("back_train_date")
        } else {
            var bY = $("#train_date").val();
            x("train_date")
        } if (rqChecked.length == 0) {
            rqChecked.push(bY)
        }
        var bZ = false;
        if (bY != rqChecked[0]) {
            for (var b0 = 0; b0 < rqChecked.length; b0++) {
                if (bY == rqChecked[b0]) {
                    bZ = true;
                    rqChecked.splice(b0, 1);
                    $("#date-list input[value=" + rqChecked[0] + "]").prop("checked", false);
                    rqChecked.splice(0, 1, bY);
                    $("#prior_date span[name=" + bY + "]").remove();
                    break
                }
            }
            if (!bZ) {
                $("#date-list input[value=" + rqChecked[0] + "]").prop("checked", false);
                rqChecked.splice(0, 1, bY);
                $("#date-list input[value=" + rqChecked[0] + "]").prop("checked", true)
            }
        }
    }
    $("#train_date").focus(function () {
        WdatePicker({
            doubleCalendar: true,
            minDate: $.getMindateForCal(),
            maxDate: $.getMaxdateForCal(),
            isShowClear: false,
            readOnly: true,
            qsEnabled: false,
            onpicked: function () {
                af();
                $("#train_date").blur();
                var bY = $("#train_date").val();
                var bZ = $("#back_train_date").val();
                if ($("#wf").is(":checked")) {
                    if (!bZ | A(bY) > A(bZ)) {
                        $("#back_train_date").val(bY)
                    }
                }
                aE()
            }
        })
    });
    $("#date_icon_1").click(function () {
        $("#train_date").focus()
    });
    $("#back_train_date").focus(function () {
        WdatePicker({
            doubleCalendar: true,
            minDate: $("#train_date").val(),
            maxDate: $.getMaxdateForCal(),
            isShowClear: false,
            readOnly: true,
            qsEnabled: false,
            onpicked: function () {
                af();
                $("#back_train_date").blur();
                aE()
            }
        })
    });
    $("#date_icon_2").click(function () {
        $("#back_train_date").focus()
    });
    String.prototype.toDate = function () {
        style = "yyyy-MM-dd hh:mm";
        var b1 = {
            "y+": "y",
            "M+": "M",
            "d+": "d",
            "h+": "h",
            "m+": "m"
        };
        var bY = {
            y: "",
            M: "",
            d: "",
            h: "00",
            m: "00"
        };
        var b0 = style;
        for (var bZ in b1) {
            if (new RegExp("(" + bZ + ")").test(style)) {
                bY[b1[bZ]] = this.substring(b0.indexOf(RegExp.$1), b0.indexOf(RegExp.$1) + RegExp.$1.length)
            }
        }
        return new Date(bY.y, bY.M - 1, bY.d, bY.h, bY.m)
    };

    function x(b2) {
        if (b2 == "back_train_date" && ClickWho != "0X00") {
            return
        }
        var bY = ($("#" + b2).val().split(" ")[0] + " 00:00:00").toDate().getTime();
        var b4 = stu_start_train_date.split("&");
        var b0 = stu_end_tain_date.split("&");
        var bZ = false;
        for (var b1 = 0, b3 = b4.length; b1 < b3; b1++) {
            if (bY >= b4[b1].toDate().getTime() && bY <= b0[b1].toDate().getTime()) {
                bZ = true;
                break
            }
        }
        if (bZ) {
            $("#sf2").attr("disabled", false);
            $("#sf2_label").removeClass("color999")
        } else {
            $("#sf2").attr("checked", false);
            $("#sf1")[0]["checked"] = "checked";
            $("#sf2").attr("disabled", true);
            $("#sf2_label").addClass("color999")
        }
    }

    function bD(bY) {
        if (isSaveQueryLog == "Y") {
            $.ajax({
                type: "get",
                isTakeParam: false,
                beforeSend: function (bZ) {
                    bZ.setRequestHeader("If-Modified-Since", "0");
                    bZ.setRequestHeader("Cache-Control", "no-cache")
                }, url: ctx + "leftTicket/log",
                data: bY,
                timeout: 1000,
                error: function (bZ, b1, b0) {}, success: function (bZ) {}
            })
        }
    }
})();

function checkG1234(g, f, c, h, b) {
    var a = "99999GGGGG";
    var e = "##CCT##PPT##CPT##PXT##SBT##PBD##JOD##HPD##SHD##QTP##TSP##TJP##";
    var d = "##CBP##DIP##JGK##ZEK##UUH##NKH##ESH##OHH##AOH##";
    if (c.indexOf(a) > -1 && e.indexOf(h) > -1 && d.indexOf(b) > -1) {
        dhtmlx.createWin({
            winId: "confirmG1234",
            closeWinId: ["close_conifrmdialog_G1234", "cancel_dialog_G1234"],
            okId: "goto_integration_G1234",
            okCallBack: function () {
                submitOrderRequest(g, f)
            }, callback: function () {
                return
            }
        })
    } else {
        submitOrderRequest(g, f)
    }
};
var left_ticket_messages = {
    "leftTicketDTO.from_station": "出发站",
    "leftTicketDTO.to_station": "目的站",
    "leftTicketDTO.train_no": "车次",
    "leftTicketDTO.train_date": "出发日",
    back_train_date: "返程日"
};
jQuery.validator.addMethod("checkLoginUserName", function (f, d) {
    var a = false;
    var c = /^(13[0-9])|(14[0-9])|(15[0-9])|(18[0-9])|(17[0-9])\d{8}$/;
    var b = /^[A-Za-z]{1}([A-Za-z0-9]|[_]){0,29}$/;
    var e = /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))$/i;
    if (b.test(f) || e.test(f) || c.test(f)) {
        a = true
    }
    return this.optional(d) || a
}, "wrong username.");
jQuery.validator.addMethod("requiredUserName", function (b, a) {
    if ("用户名／邮箱／手机号" == b) {
        return false
    }
    if (b == null || "" == b) {
        return false
    }
    return true
}, "wrong username.");
jQuery.validator.addMethod("requiredSchoolName", function (b, a) {
    if ("简码／汉字" == b) {
        return false
    }
    if (b == null || "" == b) {
        return false
    }
    return true
}, "wrong schoolname.");
jQuery.validator.addMethod("randCodeRequired", function (b, a) {
    $("#i-ok").css("display", "none");
    return b.length > 0
}, "验证码错误!");
jQuery.validator.addMethod("randCodeFormat", function (c, b) {
    $("#i-ok").css("display", "none");
    var a = /^[a-zA-Z0-9]+$/;
    return this.optional(b) || a.test(c)
}, "验证码错误!");
jQuery.validator.addMethod("randCodeLength", function (b, a) {
    $("#i-ok").css("display", "none");
    return b.length == 4
}, "验证码错误!.");
jQuery.validator.addMethod("integrationCheck", function (b, a) {
    var c = /^\d{6}$/;
    return this.optional(a) || c.test(b)
}, "wrong integrationpassword");
jQuery.validator.addMethod("integrationPwdCheck", function (b, a, c) {
    if ($("#" + c[0]).val() == $("#" + c[1]).val()) {
        return true
    }
    return false
}, "两次输入密码不一致!.");
jQuery.validator.addMethod("checkRandCode", function (c, b, d) {
    var a = true;
    if (c && c.length == 4) {
        $.ajax({
            url: ctx + "passcodeNew/checkRandCodeAnsyn",
            type: "post",
            data: {
                randCode: c,
                rand: d
            },
            async: false,
            success: function (e) {
                if (e.data == "N") {
                    a = false;
                    $("#i-ok").css("display", "none")
                } else {
                    a = true;
                    $("#i-ok").css("display", "block")
                }
            }
        })
    } else {
        a = false;
        $("#i-ok").css("display", "none")
    }
    return a
}, "验证码错误!.");
jQuery.validator.addMethod("validateUsersName", function (b, a) {
    return this.optional(a) || /^[A-Za-z]{1}([A-Za-z0-9]|[_]){0,29}$/.test(b)
}, "用户名只能由字母、数字或_组成");
jQuery.validator.addMethod("checkWriteSpace", function (c, b) {
    for (var a = 0; a < c.length; a++) {
        if (c.charCodeAt(a) == 32) {
            return false
        }
    }
    return true
}, "contain writespace");
jQuery.validator.addMethod("validateRandCode", function (b, a) {
    return this.optional(a) || /^[a-zA-Z0-9]+$/.test(b)
}, "验证码错误!.");
jQuery.validator.addMethod("checkPassward", function (c, b, e) {
    var d = true;
    for (var a = 0; a < c.length; a++) {
        if (c.charCodeAt(a) == 39 || c.charCodeAt(a) == 60 || c.charCodeAt(a) == 62) {
            d = false
        }
        if (!d) {
            break
        }
    }
    return this.optional(b) || d
}, "Passward wrong");

function validateSecIdCard(g) {
    var f = 0;
    var a = g;
    var e = {
        11: "北京",
        12: "天津",
        13: "河北",
        14: "山西",
        15: "内蒙",
        21: "辽宁",
        22: "吉林",
        23: "黑龙",
        31: "上海",
        32: "江苏",
        33: "浙江",
        34: "安徽",
        35: "福建",
        36: "江西",
        37: "山东",
        41: "河南",
        42: "湖北",
        43: "湖南",
        44: "广东",
        45: "广西",
        46: "海南",
        50: "重庆",
        51: "四川",
        52: "贵州",
        53: "云南",
        54: "西藏",
        61: "陕西",
        62: "甘肃",
        63: "青海",
        64: "宁夏",
        65: "新疆",
        71: "台湾",
        81: "香港",
        82: "澳门",
        91: "国外"
    };
    if (!/^\d{17}(\d|x)$/i.test(a)) {
        return false
    }
    a = a.replace(/x$/i, "a");
    if (e[parseInt(a.substr(0, 2))] == null) {
        return false
    }
    var c = a.substr(6, 4) + "-" + Number(a.substr(10, 2)) + "-" + Number(a.substr(12, 2));
    var h = new Date(c.replace(/-/g, "/"));
    if (c != (h.getFullYear() + "-" + (h.getMonth() + 1) + "-" + h.getDate())) {
        return false
    }
    for (var b = 17; b >= 0; b--) {
        f += (Math.pow(2, b) % 11) * parseInt(a.charAt(17 - b), 11)
    }
    if (f % 11 != 1) {
        return false
    }
    return true
}

function validateFirIdCard(g) {
    var f = 0;
    var a;
    var e = {
        11: "北京",
        12: "天津",
        13: "河北",
        14: "山西",
        15: "内蒙",
        21: "辽宁",
        22: "吉林",
        23: "黑龙",
        31: "上海",
        32: "江苏",
        33: "浙江",
        34: "安徽",
        35: "福建",
        36: "江西",
        37: "山东",
        41: "河南",
        42: "湖北",
        43: "湖南",
        44: "广东",
        45: "广西",
        46: "海南",
        50: "重庆",
        51: "四川",
        52: "贵州",
        53: "云南",
        54: "西藏",
        61: "陕西",
        62: "甘肃",
        63: "青海",
        64: "宁夏",
        65: "新疆",
        71: "台湾",
        81: "香港",
        82: "澳门",
        91: "国外"
    };
    if (g.length == 15) {
        a = idCardUpdate(g)
    } else {
        a = g
    } if (!/^\d{17}(\d|x)$/i.test(a)) {
        return false
    }
    a = a.replace(/x$/i, "a");
    if (e[parseInt(a.substr(0, 2))] == null) {
        return false
    }
    var c = a.substr(6, 4) + "-" + Number(a.substr(10, 2)) + "-" + Number(a.substr(12, 2));
    var h = new Date(c.replace(/-/g, "/"));
    if (c != (h.getFullYear() + "-" + (h.getMonth() + 1) + "-" + h.getDate())) {
        return false
    }
    for (var b = 17; b >= 0; b--) {
        f += (Math.pow(2, b) % 11) * parseInt(a.charAt(17 - b), 11)
    }
    if (f % 11 != 1) {
        return false
    }
    return true
}

function idCardUpdate(g) {
    var b;
    var f = /^(\d){15}$/;
    if (f.test(g)) {
        var e = 0;
        var a = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
        var d = new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2");
        g = g.substr(0, 6) + "19" + g.substr(6, g.length - 6);
        for (var c = 0; c < g.length; c++) {
            e += parseInt(g.substr(c, 1)) * a[c]
        }
        g += d[e % 11];
        b = g
    } else {
        b = "#"
    }
    return b
}
jQuery.validator.addMethod("checkBorth", function (e, c) {
    var b = e;
    if (b == "") {
        return true
    } else {
        var a = b.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
        if (a == null) {
            return false
        }
        var f = new Date(a[1], a[3] - 1, a[4]);
        return (f.getFullYear() == a[1] && (f.getMonth() + 1) == a[3] && f.getDate() == a[4])
    }
}, "日期格式不合法");
jQuery.validator.addMethod("byteRangeLength", function (d, b, e) {
    var c = d.length;
    for (var a = 0; a < d.length; a++) {
        if (d.charCodeAt(a) > 127) {
            c++
        }
    }
    return this.optional(b) || (c >= e[0] && c <= e[1])
}, "length wrong");
jQuery.validator.addMethod("checkNameCharBlank", function (c, b, d) {
    var a = d.split("@");
    if ($("#" + a[1]).val() == "") {
        return true
    } else {
        if ($("#" + a[0]).val() == "1" || $("#" + a[0]).val() == "2") {
            return this.optional(b) || /^[a-zA-Z·.．\u3400-\u9FFF]+$/.test(c)
        } else {
            if ($("#" + a[0]).val() == "B") {
                if (/^[-]+$/.test(c)) {
                    return false
                }
                return this.optional(b) || /^[a-z A-Z·.．\u3400-\u9FFF\-]+$/.test(c)
            } else {
                if ($("#" + a[0]).val() == "H") {
                    if (/^[-]+$/.test(c)) {
                        return false
                    }
                    return this.optional(b) || /^[a-z A-Z·。.．\u3400-\u9FFF-]+$/.test(c)
                } else {
                    return this.optional(b) || /^[a-z A-Z·.．\u3400-\u9FFF]+$/.test(c)
                }
            }
        }
    }
}, "wrong name.");
jQuery.validator.addMethod("checkIdValidStr", function (c, b) {
    var a = /^[a-zA-Z0-9\_\-\(\)]+$/;
    return this.optional(b) || (a.test(c))
}, "wrong id");
jQuery.validator.addMethod("isSecIDCard", function (b, a, c) {
    if (!checkIfSecIdCard($(c).val())) {
        return true
    }
    return validateSecIdCard(b)
}, "wrong");

function checkIfSecIdCard(a) {
    if (a == "1") {
        return true
    }
    return false
}

function checkIfFirIdCard(a) {
    if (a == "2") {
        return true
    }
    return false
}

function checkCardForHKorTW(a) {
    if (a == "C" || a == "G") {
        return true
    }
    return false
}
jQuery.validator.addMethod("isFirIDCard", function (b, a, c) {
    if (!checkIfFirIdCard($(c).val())) {
        return true
    }
    return validateFirIdCard(b)
}, "wrong");
jQuery.validator.addMethod("checkHkongMacao", function (c, b, d) {
    if ($(d).val() == "C") {
        var a = /^[HMhm]{1}([0-9]{10}|[0-9]{8})$/;
        return this.optional(b) || (a.test(c))
    } else {
        return true
    }
}, "wrong format.");
jQuery.validator.addMethod("checkTaiw", function (c, a, e) {
    if ($(e).val() == "G") {
        var d = /^[0-9]{8}$/;
        var b = /^[0-9]{10}$/;
        return this.optional(a) || (d.test(c)) || (b.test(c))
    } else {
        return true
    }
}, "wrong format.");
jQuery.validator.addMethod("checkPassport", function (d, b, e) {
    if ($(e).val() == "B") {
        var c = /^[a-zA-Z]{5,17}$/;
        var a = /^[a-zA-Z0-9]{5,17}$/;
        return this.optional(b) || (a.test(d)) || c.test(d)
    } else {
        return true
    }
}, "wrong format.");
jQuery.validator.addMethod("checkWork", function (c, b, d) {
    if ($(d).val() == "H") {
        var a = /^[a-zA-Z]{3}[0-9]{12}$/;
        return this.optional(b) || (a.test(c))
    } else {
        return true
    }
}, "wrong format.");
jQuery.validator.addMethod("isMobile", function (d, b) {
    var c = d.length;
    var a = /^(13[0-9])|(14[0-9])|(15[0-9])|(18[0-9])|(17[0-9])\d{8}$/;
    return this.optional(b) || (c == 11 && a.test(d))
}, "wrong mobile phone ");
jQuery.validator.addMethod("isTelePhone", function (b, a) {
    var c = /(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^[0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}#)/;
    return this.optional(a) || (c.test(b))
}, "wrong telePhone ");
jQuery.validator.addMethod("illegalChar", function (c, b, e) {
    var d = true;
    if (c.indexOf("$") >= 0) {
        return false
    }
    for (var a = 0; a < c.length; a++) {
        if (c.charCodeAt(a) == 39 || c.charCodeAt(a) == 60 || c.charCodeAt(a) == 62 || c.charCodeAt(a) == 34 || c.charCodeAt(a) == 63) {
            d = false
        }
        if (!d) {
            break
        }
    }
    return this.optional(b) || d
}, "Illegal char wrong");
jQuery.validator.addMethod("isZipCode", function (c, b) {
    var a = /^[0-9]{6}$/;
    return this.optional(b) || (a.test(c))
}, "wrong zipcode");
jQuery.validator.addMethod("isEmail", function (c, a) {
    var b = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return this.optional(a) || (b.test(trim(c)))
}, "wrong email");

function replaceChar(b) {
    var a = b.value.replace(/['"<> ?]/g, "");
    b.value = a
}

function checkNameChar1(a) {
    return /^[a-zA-Z0-9\u3400-\u9FFF]+$/.test(a)
}

function trim(a) {
    return a.replace(/(^\s*)|(\s*$)/g, "")
}

function ltrim(a) {
    return a.replace(/(^\s*)/g, "")
}

function rtrim(a) {
    return a.replace(/(\s*$)/g, "")
}
jQuery.validator.addMethod("validateName", function (b, a) {
    return this.optional(a) || /^[a-zA-Z\u3400-\u9FFF0-9\_]+$/.test(b)
}, "wrong username.");
jQuery.validator.addMethod("studentRequired", function (b, a, c) {
    if ($(c).val() == "3") {
        return b && trim(b) != ""
    }
    return true
}, "wrong studentRequired.");
jQuery.validator.addMethod("studentStationRequired", function (b, a, c) {
    if ($(c).val() == "3") {
        return b && trim(b) != "简拼/全拼/汉字" && trim(b) != ""
    }
    return true
}, "wrong studentStationRequired.");
jQuery.validator.addMethod("studentValidateName", function (b, a, c) {
    if ($(c).val() == "3") {
        return this.optional(a) || /^[a-zA-Z\u3400-\u9FFF0-9\_]+$/.test(b)
    }
    return true
}, "wrong username.");
jQuery.validator.addMethod("checkStudentName", function (b, a, c) {
    if ($(c).val() == "3") {
        if ((!b || trim(b) == "" || trim(b) == "简码/汉字")) {
            return false
        }
    }
    return true
}, "wrong username.");
jQuery.validator.addMethod("isQuestionNull", function (b, a, c) {
    if (jQuery.trim(b) != "") {
        if (jQuery.trim($(c[0]).val()) == "customQuestion" && jQuery.trim($(c[1]).val()) == "" || jQuery.trim($(c[0]).val()) == "") {
            return false
        }
    }
    return true
}, "you should input the question");
jQuery.validator.addMethod("isAnswerNull", function (b, a, c) {
    if ((jQuery.trim($(c[0]).val()) == "customQuestion" && jQuery.trim($(c[1]).val()) != "") || (jQuery.trim($(c[0]).val()) != "")) {
        if (jQuery.trim(b) == "") {
            return false
        }
    }
    return true
}, "you should input the answer");

function checkSex(c, b, a) {
    if (!checkSexByCardId(c, b, a)) {
        if (!confirm("性别与身份证中的性别不符，是否继续?")) {
            return false
        } else {
            return true
        }
    } else {
        return true
    }
}

function checkSexByCardId(c, e, a) {
    function b(h, i) {
        var g = null;
        if (i.length == 15) {
            g = i.substring(14, 15)
        } else {
            if (i.length == 18) {
                g = i.substring(16, 17)
            } else {
                return true
            }
        } if (g == "x" || g == "X") {
            g = "10"
        }
        var f = parseInt(g);
        var j = f % 2;
        if (j === 0 && h === "F") {
            return true
        } else {
            if (j === 1 && h === "M") {
                return true
            } else {
                return false
            }
        }
    }
    var d = $(a).val();
    if (checkIfSecIdCard($(e).val()) && validateSecIdCard(d)) {
        if (d !== "") {
            return b(c, d)
        } else {
            return true
        }
    } else {
        if (checkIfFirIdCard($(e).val()) && validateFirIdCard(d)) {
            if (d !== "") {
                return b(c, d)
            } else {
                return true
            }
        } else {
            return true
        }
    }
}

function checkBirdDateByCardId(c, e, b) {
    var a = null;
    var d = $(b).val();
    if (checkIfSecIdCard($(e).val()) && d !== "" && validateSecIdCard(d)) {
        a = d.substring(6, 14)
    } else {
        if (checkIfFirIdCard($(e).val()) && d !== "" && validateFirIdCard(d)) {
            if (d.length == 15) {
                a = "19" + d.substring(6, 12)
            } else {
                if (d.length == 18) {
                    a = d.substring(6, 14)
                }
            }
        } else {
            return true
        }
    } if (c !== "") {
        c = c.replace(/-/g, "");
        if (c != a) {
            return false
        } else {
            return true
        }
    } else {
        return true
    }
}

function checkBirdate(c, b, a) {
    if (!checkBirdDateByCardId(c, b, a)) {
        if (!confirm("出生日期与身份证中的出生日期不符，是否继续?")) {
            return false
        } else {
            return true
        }
    } else {
        return true
    }
}
jQuery.validator.addMethod("checkPwdValidate", function (b, a) {
    return this.optional(a) || /(?![a-z]+$|[0-9]+$|_+$)^[a-zA-Z0-9_]{6,}$/.test(b)
}, "contain writespace");
jQuery.validator.addMethod("checkConfirmPassWard", function (b, a, c) {
    if ($(c).val() != null) {
        return $(c).val() == b
    }
    return true
}, "contain writespace");
jQuery.validator.addMethod("IVR_passwd_format", function (b, a) {
    var c = /^[0-9]{6}$/;
    return this.optional(a) || c.test(b)
}, "验证码错误!.");
jQuery.validator.addMethod("checkStation", function (b, a) {
    if ((!b || trim(b) == "" || trim(b) == "简拼/全拼/汉字" || trim(b) == "简拼/全拼/汉字或↑↓")) {
        return false
    }
    return true
}, "wrong username.");
jQuery.validator.addMethod("checkAnsyUserName", function (e, c, f) {
    var b = f[0];
    var d = $("#" + f[1]).val();
    var a = true;
    $.ajax({
        url: b + "?user_name=" + e,
        type: "get",
        async: false,
        success: function (g, h) {
            if (g.data == true) {
                a = false
            } else {
                a = true
            }
        }, error: function (g, i, h) {
            a = false
        }
    });
    return a
}, "wrong cardNo");

function checkPwdRank(e, a, d) {
    var b = $(e);
    var c = b.val();
    if (c.length <= 6 || new RegExp("^[a-zA-Z]{6,}$").test(c) || new RegExp("^[0-9]{6,}$").test(c) || new RegExp("^[_]{6,}$").test(c)) {
        $("#" + a).attr("title", "危险");
        $("#" + d).html("危险");
        $("#" + a).removeClass("rank-a");
        $("#" + a).removeClass("rank-b");
        $("#" + a).removeClass("rank-c");
        $("#" + a).addClass("rank-a")
    } else {
        if (c.length > 6 && new RegExp("[a-zA-Z]").test(c) && new RegExp("[0-9]").test(c) && new RegExp("[_]").test(c)) {
            $("#" + a).attr("title", "安全");
            $("#" + d).html("安全");
            $("#" + a).removeClass("rank-a");
            $("#" + a).removeClass("rank-b");
            $("#" + a).removeClass("rank-c");
            $("#" + a).addClass("rank-c")
        } else {
            $("#" + a).attr("title", "一般");
            $("#" + d).html("一般");
            $("#" + a).removeClass("rank-a");
            $("#" + a).removeClass("rank-b");
            $("#" + a).removeClass("rank-c");
            $("#" + a).addClass("rank-b")
        }
    }
}
Array.prototype.unique = function () {
    var b = {},
        a = this.length;
    for (var c = 0; c < a; c++) {
        if (typeof b[this[c]] == "undefined") {
            b[this[c]] = 1
        }
    }
    this.length = 0;
    a = 0;
    for (var c in b) {
        this[a++] = c
    }
    return this
};

function checkSearchPwdRank(h, c, g) {
    var e = $(h);
    var f = e.val();
    if (f.length < 6) {
        $("#" + c).attr("title", "危险");
        $("#" + g).html("危险");
        $("#" + c).removeClass("rank-a");
        $("#" + c).removeClass("rank-b");
        $("#" + c).removeClass("rank-c");
        $("#" + c).addClass("rank-a")
    } else {
        var a = [];
        for (var b = 0; b < 6; b++) {
            a.push(f.charAt(b))
        }
        a = a.unique();
        var d = a.length;
        if (d == 1) {
            $("#" + c).attr("title", "危险");
            $("#" + g).html("危险");
            $("#" + c).removeClass("rank-a");
            $("#" + c).removeClass("rank-b");
            $("#" + c).removeClass("rank-c");
            $("#" + c).addClass("rank-a")
        } else {
            if (d > 1 && d < 5) {
                $("#" + c).attr("title", "一般");
                $("#" + g).html("一般");
                $("#" + c).removeClass("rank-a");
                $("#" + c).removeClass("rank-b");
                $("#" + c).removeClass("rank-c");
                $("#" + c).addClass("rank-b")
            } else {
                $("#" + c).attr("title", "安全");
                $("#" + g).html("安全");
                $("#" + c).removeClass("rank-a");
                $("#" + c).removeClass("rank-b");
                $("#" + c).removeClass("rank-c");
                $("#" + c).addClass("rank-c")
            }
        }
    }
}
jQuery.validator.addMethod("checkDetailAddress", function (b, a) {
    return this.optional(a) || /^[0-9a-zA-Z\u3400-\u9FFF\#]+$/.test(b)
}, "wrong name.");
jQuery.validator.addMethod("checkAddressName", function (b, a) {
    if (/^[-]+$/.test(b)) {
        return false
    }
    return this.optional(a) || /^[a-z A-Z·.．\u3400-\u9FFF\-]+$/.test(b) || /^[a-zA-Z·.．\u3400-\u9FFF]+$/.test(b)
}, "wrong name.");
jQuery.validator.addMethod("checkAddressSelect", function (b, a) {
    if ("" == b) {
        return false
    }
    if (b) {
        return true
    }
    return this.optional(a)
}, "wrong name.");
var login_messages = {
    randCodeError: "验证码错误!",
    randCodeExpired: "验证码失效",
    randCodeLentgh: "验证码长度为4位!",
    randCodeFormat: "验证码只能由数字或字母组成!",
    randCodeEmpty: "验证码不能为空!",
    userNameEmpty: "登录名必须填写!",
    userNameFormat: "登录名格式不正确，请重新输入!",
    passwordEmpty: "密码必须填写,且不少于6位!",
    passwordLength: "密码长度不能少于6位!",
    pleaseClickCaptcha: "请点击验证码",
    pleaseClickLeftCaptcha: "请点击左侧验证码",
    pleaseClickCaptchaRight: "请点击正确的验证码",
    pleaseClickBottomCaptcha: "请点击下方验证码",
    loginError: "当前访问用户过多,请稍候重试!",
    submitAfterVerify: "提交",
    pleaseClickSubmitButtonAfterClick: "pleaseClickSubmitButtonAfterClick",
    leftTicketOrderNoteMessage: '点击"提交"按钮获取验证码',
    leftTicketOrderClickCallbackNoteMessage: '完成选择后，继续点击下方橙色"提交"按钮提交订单',
    leftTicketOrderShowCallbackNoteMessage: "按照提示点击选择所有的图片",
    leftTicketOrderHiddenCallbackNoteMessage: '点击"提交"按钮获取验证码',
    getCaptchaByClick: "点击获取验证码"
};