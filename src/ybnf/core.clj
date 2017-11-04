(ns ybnf.core
  (:import ybnf.compiler)
  (:require [ybnf.grammar :as gm]
            [clojure.pprint :as pp]))

(def lang-test
  "#YBNF 0.1 utf8;
   service common;
   root $main;
   $main = $poetry_main;

   $author{author} = 丁仙芝|万楚|上官仪|上官昭容|丘为|严恽|严武|严续姬|严维|临淄县主
   |乔知之|于季子|于武陵|于濆|于良史|于鹄|令狐楚|任华|任希古|任翻|伊用昌|何希尧|佚名|修睦|储光羲|储嗣宗
   |元稹|元结|冯延巳|冯待征|冯著|冯道|冷朝阳|刘义度|刘云|刘兼|刘叉|刘商|刘复|刘威|刘希夷|刘庭琦|刘得仁
   |刘方平|刘昚虚|刘昭禹|刘晏|刘沧|刘皂|刘禹锡|刘绮庄|刘言史|刘象|刘采春|刘长卿|刘驾|包佶|包融|华山老人
   |南唐失名僧|南巨川|卢仝|卢僎|卢延让|卢殷|卢汝弼|卢照邻|卢纶|卢肇|卢象|厉玄|可朋|可止|史青|司空图|司空曙
   |司马扎|同谷子|吕太一|吕岩|吕温|吴仁璧|吴公|吴大江|吴融|周匡物|周昙|周朴|周濆|周贺|和凝|唐备|唐彦谦
   |唐求|喻凫|处默|夏侯审|夏侯楚|太上隐者|太原妓|姚合|子兰|孔德绍|孔氏|孔绍安|孙元晏|孙光宪|孙思邈|孙昌胤
   |孙逖|孙革|孙頠|孙鲂|孟云卿|孟宾于|孟昶|孟浩然|孟郊|宋之问|宋雍|宜芬公主|宣宗宫人|寒山|尚颜|屈同仙|岑参
   |崇圣寺鬼|崔信明|崔元翰|崔善为|崔国辅|崔季卿|崔峒|崔怀宝|崔护|崔曙|崔橹|崔涂|崔涤|崔液|崔湜|崔珏|崔莺莺
   |崔道融|崔郊|崔铉|崔颢|布燮|常建|常楚老|庄南杰|应物|康庭芝|张为|张乔|张九龄|张仲素|张南史|张又新|张夫人
   |张子容|张孜|张巡|张建封|张循之|张志和|张敬忠|张文姬|张文琮|张文规|张旭|张易之|张松龄|张泌|张演|张潮
   |张登|张白|张碧|张祜|张窈窕|张立|张籍|张纮|张继|张翚|张若虚|张蠙|张说|张谓|张谔|彭晓|徐凝|徐夤|徐彦伯
   |徐惠|徐昌图|徐铉|徐锴|德容|怀濬|惠能|慕幽|戎昱|成彦雄|成真人|戚逍遥|戴叔伦|捧剑仆|文秀|方干|施肩吾|无可
   |无名氏|晁采|景云|曹修古|曹唐|曹松|曹邺|朝衡|朱光弼|朱庆馀|朱放|权德舆|李世民|李中|李中碧|李九龄|李从谦
   |李冶|李华|李叔霁|李咸用|李商隐|李嘉祐|李太玄|李如璧|李存勖|李山甫|李峤|李康成|李建勋|李建枢|李微|李德裕
   |李忱|李敬方|李昂|李昌符|李昪|李曜|李治|李泌|李洞|李涉|李涛|李瀚|李煜|李珣|李璟|李白|李百药
   |李益|李端|李约|李绅|李群玉|李翱|李舜弦|李贞白|李贤|李贺|李远|李遐周|李適之|李郢|李隆基|李颀|李频|杜光庭
   |杜审言|杜牧|杜甫|杜荀鹤|来鹄|杨凭|杨巨源|杨志坚|杨敬之|杨炯|杨玉环|杨虞卿|杨衡|林杰|林滋|柳中庸|柳宗元
   |柳氏|柳郴|栖一|栖白|栖蟾|楼颖|欧阳炯|欧阳衮|欧阳詹|欧阳询|武元衡|武则天|武平一|段成式|殷尧藩|殷文圭|殷益
   |毛文锡|毛熙震|江为|江采萍|汪遵|沈亚之|沈佺期|沈如筠|沈彬|油蔚|洛川仙女|洞庭龙君|清江|温宪|温庭皓|温庭筠
   |湘驿女子|潘咸|灵一|焦郁|熊皎|牛峤|牛希济|牛殳|牟融|狄仁杰|独孤及|玄宝|王之涣|王仁裕|王初|王勃|王周|王季友
   |王宏|王建|王无竞|王昌龄|王毂|王涣|王涯|王湾|王珪|王琚|王绩|王维|王缙|王翰|王諲|王贞白|王轩|王適|王驾|畅当
   |畅诸|白居易|白氏|皇甫冉|皇甫曾|皇甫松|皎然|皮日休|知玄|祖咏|秦韬玉|窦叔向|窦巩|窦庠|窦群|章孝标|章碣|童翰卿
   |綦毋潜|缪氏子|罗邺|罗隐|羊士谔|翁宏|翁承赞|翁洮|翁绶|耿湋|聂夷中|胡令能|胡宿|胡曾|胡皓|花蕊夫人|苏味道|苏拯
   |苏颋|萧遘|葛鸦儿|董思恭|蒋吉|蒋维翰|蒋贻恭|蓝采和|蔡京|薛昭蕴|薛涛|薛稷|薛能|薛莹|薛逢|虚中|虞世南|袁郊|裴夷直
   |裴度|裴说|裴迪|褚朝阳|褚载|褚遂良|西施|西鄙人|詹琲|许棠|许浑|许玫|谭用之|贯休|贺兰进明|贺知章|贾岛|贾弇|贾至
   |赵嘏|赵彦昭|赵徵明|越溪杨女|辛弘智|邵谒|郎士元|郑准|郑愔|郑畋|郑谷|郑遨|郑鏦|郑锡|郭元振|郭子仪|郭恭|郭震|金地藏
   |金昌绪|钟离权|钱珝|钱起|长孙佐辅|长孙无忌|长孙氏|阎朝隐|阎选|阴行先|陆畅|陆羽|陆肱|陆龟蒙|陈光|陈凝|陈去疾|陈叔达
   |陈子昂|陈玉兰|陈羽|陈陶|陶翰|隐峦|雍裕之|雍陶|韦元甫|韦嗣立|韦安石|韦庄|韦应物|韦式|韦承庆|韦璜|韩偓|韩察|韩愈
   |韩湘|韩琮|韩翃|项斯|顾云|顾况|顾夐|顾非熊|颜仁郁|颜真卿|颜粲|马戴|骆宾王|高蟾|高越|高适|高骈|魏万|魏徵|魏承班
   |鱼玄机|鲍君徽|鲍溶|鲍防|鹿虔扆|麻温其|黄巢|黄损|黄滔|黄蘖禅师|齐己|齐浣|龙女;
   $name = 静夜诗|赠汪伦;
   $shi{action} = 诗|$name;
   $poetry_main{service%poetry} = $author 的 $shi;
")

(def ttt "李白的赠汪伦")

(defn -main
  [& args]
  (let [cp (ybnf.compiler. lang-test)]
    (.mergeGrammar cp "<_yyd_han_> = #'\\p{script=Han}'\n<_yyd_digital_> = #'\\d'\n<_yyd_num_> = _yyd_digital_+")
;    (pp/pprint (.getFailure cp))
    (println (.getGrammar cp))
;    (pp/pprint (.get (.state cp) "tree"))
    (pp/pprint (.getKeyValue cp))
    (pp/pprint (.execCompile cp ttt))
  ))


