package com.dexfun.yiku.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Smile on 18/1/5.
 */

public class BrandAllListEntity extends DefaultEntity {
    /**
     * msg : null
     * data : {"brandBannerImgList":[{"brandImgId":1,"brandImgUrl":"https://www.dexfun.com/img/logo200x200.png"},{"brandImgId":2,"brandImgUrl":"https://www.dexfun.com/img/logo200x200.png"},{"brandImgId":3,"brandImgUrl":"https://www.dexfun.com/img/logo200x200.png"}],"brandVoList":[{"brandId":12,"brandName":"Supreme","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86%E5%93%81%E7%89%8C@2x.png","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/%E9%A6%96%E9%A1%B5%E5%93%81%E7%89%8C@2x.png","brandDesc":"Supreme1994年秋季诞生于美国纽约曼哈顿，由James Jebbia创办。supreme的本意是最高、至上的。Supreme是结合滑板、Hip-hop等文化并以滑板为主的美国街头服饰品牌。","brandListImg":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86@2x.png","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E5%9B%BE@2x.png","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E8%AF%A6%E6%83%85%E5%93%81%E7%89%8C@2x.png"},{"brandId":13,"brandName":"DHC","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86%E5%93%81%E7%89%8C@2x.png","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/%E9%A6%96%E9%A1%B5%E5%93%81%E7%89%8C@2x.png","brandDesc":"DHCdesc","brandListImg":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86@2x.png","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E5%9B%BE@2x.png","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E8%AF%A6%E6%83%85%E5%93%81%E7%89%8C@2x.png"},{"brandId":14,"brandName":"ENVOY","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86%E5%93%81%E7%89%8C@2x.png","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/%E9%A6%96%E9%A1%B5%E5%93%81%E7%89%8C@2x.png","brandDesc":"ENVOYdesc","brandListImg":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86@2x.png","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E5%9B%BE@2x.png","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E8%AF%A6%E6%83%85%E5%93%81%E7%89%8C@2x.png"},{"brandId":15,"brandName":"ELLE","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86%E5%93%81%E7%89%8C@2x.png","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/%E9%A6%96%E9%A1%B5%E5%93%81%E7%89%8C@2x.png","brandDesc":"ELLEdesc","brandListImg":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86@2x.png","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E5%9B%BE@2x.png","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E8%AF%A6%E6%83%85%E5%93%81%E7%89%8C@2x.png"},{"brandId":16,"brandName":"Evisu","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86%E5%93%81%E7%89%8C@2x.png","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/%E9%A6%96%E9%A1%B5%E5%93%81%E7%89%8C@2x.png","brandDesc":"Evisudesc","brandListImg":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86@2x.png","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E5%9B%BE@2x.png","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E8%AF%A6%E6%83%85%E5%93%81%E7%89%8C@2x.png"},{"brandId":17,"brandName":"EVGA","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86%E5%93%81%E7%89%8C@2x.png","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/%E9%A6%96%E9%A1%B5%E5%93%81%E7%89%8C@2x.png","brandDesc":"EVGAdesc","brandListImg":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86@2x.png","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E5%9B%BE@2x.png","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E8%AF%A6%E6%83%85%E5%93%81%E7%89%8C@2x.png"},{"brandId":18,"brandName":"Dior","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86%E5%93%81%E7%89%8C@2x.png","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/%E9%A6%96%E9%A1%B5%E5%93%81%E7%89%8C@2x.png","brandDesc":"Diordesc","brandListImg":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86@2x.png","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E5%9B%BE@2x.png","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E8%AF%A6%E6%83%85%E5%93%81%E7%89%8C@2x.png"},{"brandId":41,"brandName":"Amour ","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Amour /littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Amour /LargeLogo","brandDesc":"来自韩国的综合性品牌，喜欢Amour品牌的女性有着自己独特的定位，对于时尚又着一番属于自己的理解与自信，追求的是一种精致以及经典女性魅力和感觉。精致而优雅，魅惑且智慧。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Amour /ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Amour /DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Amour /DetailLogo"},{"brandId":42,"brandName":"ANN TAYLOR","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/ANN TAYLOR/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/ANN TAYLOR/LargeLogo","brandDesc":"1954年创立的品牌，以经典而轻松的样式备受欢迎，以优雅为致胜的秘诀，有着\u201c美国第一行政品牌\u201d之称，专门服务高等教育的知识女性，是优雅高品质职场装的必备品牌。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/ANN TAYLOR/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/ANN TAYLOR/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/ANN TAYLOR/DetailLogo"},{"brandId":43,"brandName":"ArtFusion","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/ArtFusion/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/ArtFusion/LargeLogo","brandDesc":"该品牌来自于丹麦哥本哈根，一个全新的时尚品牌，美学思维传承与斯堪的纳维亚这片净土，闲适的生活情调及简约的生活方式贯穿整个品牌，所有印花均来自创意无限的设计师灵感及作品，色彩丰富并将每个系列印花赋予独特意义，品牌渴求传达给人们诗意闲适，及宁静的自然生活理念。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/ArtFusion/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/ArtFusion/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/ArtFusion/DetailLogo"},{"brandId":44,"brandName":"Asilio","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Asilio/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Asilio/LargeLogo","brandDesc":"澳洲时尚女装品牌，以简约的廓形和特殊的面料闻名全球，Asilio设计独特，个性化但不失女性感，面料和颜色的混搭往往能带来出其不意的惊喜，穿搭性极高，深受国际潮人喜爱。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Asilio/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Asilio/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Asilio/DetailLogo"},{"brandId":45,"brandName":"bardot","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/bardot/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/bardot/LargeLogo","brandDesc":"澳大利亚时尚时装品牌，成立于1996年，在当地有极高的声誉，bardot以它独特魅力已在美国和欧洲时尚舞台崭露头角。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/bardot/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/bardot/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/bardot/DetailLogo"},{"brandId":46,"brandName":"bcbg","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/bcbg/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/bcbg/LargeLogo","brandDesc":"CBG (BCBG Max Azria) 品牌由设计师MAX AZRIA于1989年在美国创建，BCBG是取自法文的原意\u201cBon Chic, Bon Genre\u201d即好的款式与好的仪态。曾在巴黎设计女性服饰长达11年之久的麦克斯·阿兹利亚 (Max Azria)，就是希望将欧式设计风格及美式生活型态相结合，以满足现代女性的欲望与需求。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/bcbg/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/bcbg/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/bcbg/DetailLogo"},{"brandId":47,"brandName":"BEBE","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/BEBE/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/BEBE/LargeLogo","brandDesc":"美国知名女装成衣零售商Bebe Stores拥有的高端品牌。Bebe Stores旗下有3个子品牌：碧碧（Bebe）、BEBE SPORT和2b bebe。碧碧（Bebe）女装体现女人自信且美丽多变，轻松、休闲的设计，恰到好处地表现了现代人崇尚个性、自然、不张扬的审美趋向，让更多喜欢时尚的女士有了释放自己的空间。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/BEBE/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/BEBE/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/BEBE/DetailLogo"},{"brandId":48,"brandName":"CALVIN KLEIN","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/CALVIN KLEIN/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/CALVIN KLEIN/LargeLogo","brandDesc":"Calvin Klein是全球生活品牌，体现现代时尚风格，保持真实的纯粹，自然和基本简约的美感。从服装，配饰，内衣和香水，独特的设计和争议性的广告活动是创新，大胆和前卫，混合美式的洒脱和性感。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/CALVIN KLEIN/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/CALVIN KLEIN/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/CALVIN KLEIN/DetailLogo"},{"brandId":49,"brandName":"DAZZLE","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/DAZZLE/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/DAZZLE/LargeLogo","brandDesc":"Dazzle是地素时尚股份有限公司旗下女装品牌，融合了意大利的文化底蕴和现代运动休闲娱乐的时尚思潮。2002年创立于中国的时尚之都上海，是一家多品牌运作的服饰时尚集团。为创造并引导个性化的生活方式，地素时尚分别创立三个知名女装品牌\u2014\u2014独立率性的专属高街品牌DAZZLE，年轻奢华的半手工定制品牌DIAMOND DAZZLE，以及奇幻复古的混搭潮流品牌d'zzit。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/DAZZLE/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/DAZZLE/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/DAZZLE/DetailLogo"},{"brandId":50,"brandName":"DKNY","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/DKNY/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/DKNY/LargeLogo","brandDesc":"DKNY创立于1989年，是一个前卫、时尚、休闲的时装品牌，从充满街头感的造型、大胆的秀场装置、音乐中，都能感受到DKNY所散发出的一种传统时装所缺少的真实\u2014\u2014把复杂混搭的东西进行拆解，使其看起来更加简单平常化，然后再把这些时尚的元素组合在一起，看起来像是没有任何的伪装。 ","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/DKNY/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/DKNY/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/DKNY/DetailLogo"},{"brandId":51,"brandName":"DVF","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/DVF/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/DVF/LargeLogo","brandDesc":"Diane von Furstenberg是美国时装界尊尚品牌，於1972年由设计师本人所创立。DVF公司总部设於纽约市，产品遍及全球多於55个国家及1500个销售点，当中包括广布南北美洲、 欧洲、中东和亚太区的101间专门店和特许经营店。\r\n","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/DVF/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/DVF/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/DVF/DetailLogo"},{"brandId":52,"brandName":"FIVEP PLUS","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/FIVEP PLUS/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/FIVEP PLUS/LargeLogo","brandDesc":"Five Plus创立于2009年，为赫基国际（香港）集团旗下自创品牌之一。 Five Plus 与国际流行趋势同步，以独特的细节和多元化的混搭，推崇欧式浪漫的女性美，但同时又流露独特的个性和无拘无束的感觉。 Five Plus不仅是现代摩登女性浪漫个性的新诠释，而且透过独特的时装语言，试图唤醒女性心中梦想。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/FIVEP PLUS/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/FIVEP PLUS/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/FIVEP PLUS/DetailLogo"},{"brandId":53,"brandName":"Fiee people","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Fiee people/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Fiee people/LargeLogo","brandDesc":"Free People 是成立于美国，标志性的现代时尚品牌。不断追求创意的自由和品质，以波西米亚、大都会、甜美、前卫及性感等多重设计理念享誉全球。设计师们的灵感来自大千世界的各个角落， 力求最大程度表现出 Free People 女孩的热情，聪慧，浪漫，自信，标新立异，追求自由，积极向上。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Fiee people/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Fiee people/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Fiee people/DetailLogo"},{"brandId":54,"brandName":"forever 21","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/forever 21/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/forever 21/LargeLogo","brandDesc":"forever 21是美国当下最火热的时装品牌，也是美国的标志性快时尚品牌，遍布全球500多家连锁店，成为美国年轻人最喜欢的服饰品牌。它曾多次出现在热门美剧中。以每天百款上新及平易近人的价格，深受全世界的欢迎。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/forever 21/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/forever 21/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/forever 21/DetailLogo"},{"brandId":55,"brandName":"GUESS","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/GUESS/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/GUESS/LargeLogo","brandDesc":"GUESS服饰品牌，成立于1981年，最初是从牛仔起家，一心向往美国风情的Marciano四兄弟，从法国南部来到这块自由天堂，却碰上了美国服饰业的萧条时期，可是，他们首次推出的「梦露式」紧身牛仔裤却在一夕之间销售一空，于是GUESS品牌正式成立。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/GUESS/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/GUESS/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/GUESS/DetailLogo"},{"brandId":56,"brandName":"Hugo Boss","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Hugo Boss/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Hugo Boss/LargeLogo","brandDesc":"HUGO BOSS是世界知名奢侈品牌，源于德国，BOSS品牌的消费群定位是城市白领，具体又细分为以正装为主的黑牌系列(Black Label)，以休闲装为主的橙牌系列(Orange Label)和以户外运动服装为主的绿牌系列(Green Label)。\r\n","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Hugo Boss/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Hugo Boss/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Hugo Boss/DetailLogo"},{"brandId":57,"brandName":"Halston Heritage","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Halston Heritage/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Halston Heritage/LargeLogo","brandDesc":"Roy Halston Frowick是奢侈美国时尚的创始人，他的开创性设计依然在今天影响并激发着我们。创立于20世纪60年代的Halston品牌完全征服了时尚产业。Halston得名于在女帽上的创新，他用他标志性的材质比如平纹布，开司米以及小山羊皮来重塑连衣裤，衬衫连衣裙以及经典的长袖服，在时尚中留下了他永恒的标志。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Halston Heritage/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Halston Heritage/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Halston Heritage/DetailLogo"},{"brandId":58,"brandName":"ILOVECHOC","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/ILOVECHOC/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/ILOVECHOC/LargeLogo","brandDesc":"ILOVECHOC是以青春街头时尚潮流为主的潮牌，[1]  ILOVECHOC致力于引领潮流未来趋势，倡导传播爱与欢乐，将爱与欢乐迸发出的ILOVECHOC美学融入到每一件设计作品里。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/ILOVECHOC/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/ILOVECHOC/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/ILOVECHOC/DetailLogo"},{"brandId":59,"brandName":"Juicy Couture","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Juicy Couture/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Juicy Couture/LargeLogo","brandDesc":"Juicy Couture （橘滋） 是美国加州的时尚品牌，主要经营女装、男士服饰、童装、运动休闲服饰、宠物服饰、手链、腕表、包包、香水，由帕米拉·思凯斯特·利维(Pamela Skaist-Levy) 和吉拉·奈什(Gela Nash)于1995年共同创建。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Juicy Couture/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Juicy Couture/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Juicy Couture/DetailLogo"},{"brandId":60,"brandName":"Kate Spade","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Kate Spade/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Kate Spade/LargeLogo","brandDesc":"由Katherine Noel Brosnahan创办，是纽约时装周的常客，以简洁灵动的造型，鲜亮大胆的颜色以及活泼有趣的生活态度风靡纽约。它用活力无限的大胆色调表现出kate spade new york女孩内心对于未来的美好憧憬和无所畏惧。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Kate Spade/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Kate Spade/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Kate Spade/DetailLogo"},{"brandId":61,"brandName":"Lily","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Lily/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Lily/LargeLogo","brandDesc":"Lily是女性时装品牌，秉承时尚与商务完美融合的理念，以清新明快、现代简约的风格，为都市年轻职业女性设计商务场合\"正合适\"的商务时装。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Lily/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Lily/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Lily/DetailLogo"},{"brandId":62,"brandName":"MAX MARA","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/MAX MARA/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/MAX MARA/LargeLogo","brandDesc":"意大利品牌MaxMara 的诞生始于1951年，1951年，Achille Maramotti在家乡小镇开设第一间MaxMara，推出第一个时装系列：一件骆驼色大衣、一套粉红色套装，现在MaxMara集团共有二十三个品牌系列，1983年，MaxMara开始推行特许经营店，集团销售网几乎已涵盖整个意大利市场。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/MAX MARA/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/MAX MARA/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/MAX MARA/DetailLogo"},{"brandId":63,"brandName":"MO&Co","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/MO&Co/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/MO&Co/LargeLogo","brandDesc":"MO&Co.于2004年诞生，一直以来以旗帜鲜明的创新理念、独特个性的设计与裁剪迅速成为了备受瞩目的主流时尚品牌。擅长以天然的材质、内敛的裁剪和独特的细节演绎型格又略带女人味的摩登法式风格，贯穿怀旧和当代，以充满激情的创造力将艺术和时装联系在一起，于视觉艺术、立体结构主义中寻找一切创作灵感。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/MO&Co/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/MO&Co/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/MO&Co/DetailLogo"},{"brandId":64,"brandName":"Moschino","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Moschino/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Moschino/LargeLogo","brandDesc":"Moschino是设计师franco moschino以自己的名字命名的一个意大利品牌，创立于1983年，产品以设计怪异著称，风格高贵迷人、时尚幽默、俏皮为主线，主要产品有高级成衣、牛仔装、晚宴装及服装配饰。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Moschino/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Moschino/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Moschino/DetailLogo"},{"brandId":65,"brandName":"Marches","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Marches/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Marches/LargeLogo","brandDesc":"英国新兴品牌玛切萨（Marchesa) 在2004年才由两名年轻女设计师Georgina Chapman（乔治娜·查普曼）及Keren Craig创立，玛切萨 (Marchesa)以昂贵的布料材质、精细的车工、特殊的剪裁火速上位，赢得欧美女星名媛的追捧。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Marches/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Marches/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Marches/DetailLogo"},{"brandId":66,"brandName":"Ochirly","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Ochirly/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Ochirly/LargeLogo","brandDesc":"始创于1999年的ochirly，品牌名称源自中文欧时力，寓意来自欧洲的时尚魅力。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Ochirly/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Ochirly/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Ochirly/DetailLogo"},{"brandId":68,"brandName":"Ted Baker","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Ted Baker/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Ted Baker/LargeLogo","brandDesc":"Ted Baker创办于1988年，Ted Baker的成功秘诀在于更为大胆的诠释、对卓越品质的不懈追求、对细节一丝不苟的关注以及独特的英式幽默，融成别具一格的Ted Baker风格，自然不落俗套。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Ted Baker/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Ted Baker/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Ted Baker/DetailLogo"},{"brandId":69,"brandName":"Three Floor","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Three Floor/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Three Floor/LargeLogo","brandDesc":"Three Floor是一个英国的服装品牌，也是一个很新的品牌，今年刚成立的英国品牌Three Floor，系列中融合了浪漫柔和以及坚韧不拔的设计元素，让每一块的造型都巧妙并存。从服装风格来讲，比传统的英系服装更简洁，更多一些时尚元素，在色彩运用上，也更为大胆。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Three Floor/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Three Floor/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Three Floor/DetailLogo"},{"brandId":70,"brandName":"Tory Burch","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Tory Burch/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Tory Burch/LargeLogo","brandDesc":"Tory Burch成立于2004 年2月，它是一个实际可行的时尚生活方式品牌，源于经典的美国运动时装风格，充满无拘无束的活力与感觉，其共混永恒的，经典的设计元素与现代时尚的感情。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Tory Burch/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Tory Burch/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Tory Burch/DetailLogo"},{"brandId":71,"brandName":"USEPARIS","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/USEPARIS/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/USEPARIS/LargeLogo","brandDesc":"use原创女装以\u201c删繁就简\u201d为品牌哲学，摒弃复杂且矫揉造作的细节，将简约融入生活，在时尚中提炼实用性，呈现服装最纯粹的线条，凸显女性的完美气质。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/USEPARIS/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/USEPARIS/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/USEPARIS/DetailLogo"},{"brandId":72,"brandName":"Victoria's secret","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Victoriassecret/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Victoria's secret/LargeLogo","brandDesc":"维多利亚的秘密(Victoria's Secret)对于性感美艳的定义早已昭然若揭，天使的长发自然的微卷，象刚刚睡醒尚未梳洗或才经历一场完美的性爱。面容自然媚态，红绯绯的脸庞和雾茫茫的双眸象刚刚接吻过的嘴唇。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Victoria's secret/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Victoria's secret/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Victoria's secret/DetailLogo"},{"brandId":73,"brandName":"Valentino","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Valentino/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Valentino/LargeLogo","brandDesc":"Valentino创作表达现代人本主义，着重穿戴者的个性。理念、产品、零售店都可找到相同的特质：从独一无二的高级定制作品到男女成衣系列及配饰，从眼镜到香熏和专门店，尽显Valentino气质优雅、清新脱俗、工艺卓越、与众不同的典范。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Valentino/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Valentino/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Valentino/DetailLogo"},{"brandId":74,"brandName":"Zara","brandLittleLogo":"http://p198v6g26.bkt.clouddn.com/brand/Zara/littleLogo","brandLargeLogo":"http://p198v6g26.bkt.clouddn.com/brand/Zara/LargeLogo","brandDesc":"ZARA深受全球时尚青年的喜爱，设计师品牌的优异设计价格却更为低廉，简单来说就是让平民拥抱High Fashion。","brandListImg":"http://p198v6g26.bkt.clouddn.com/brand/Zara/ListImg","brandDetailImg":"http://p198v6g26.bkt.clouddn.com/brand/Zara/DetailImg","brandDetailLogo":"http://p198v6g26.bkt.clouddn.com/brand/Zara/DetailLogo"}]}
     * success : true
     */


    private DataEntity data;
    private boolean success;



    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataEntity {
        private List<BrandBannerImgListEntity> brandBannerImgList;
        private List<BrandVoListEntity> brandVoList;

        public List<BrandBannerImgListEntity> getBrandBannerImgList() {
            return brandBannerImgList;
        }

        public void setBrandBannerImgList(List<BrandBannerImgListEntity> brandBannerImgList) {
            this.brandBannerImgList = brandBannerImgList;
        }

        public List<BrandVoListEntity> getBrandVoList() {
            return brandVoList;
        }

        public void setBrandVoList(List<BrandVoListEntity> brandVoList) {
            this.brandVoList = brandVoList;
        }

        public static class BrandBannerImgListEntity {
            /**
             * brandImgId : 1
             * brandImgUrl : https://www.dexfun.com/img/logo200x200.png
             */

            private int brandImgId;
            private String brandImgUrl;

            public int getBrandImgId() {
                return brandImgId;
            }

            public void setBrandImgId(int brandImgId) {
                this.brandImgId = brandImgId;
            }

            public String getBrandImgUrl() {
                return brandImgUrl;
            }

            public void setBrandImgUrl(String brandImgUrl) {
                this.brandImgUrl = brandImgUrl;
            }
        }

        public static class BrandVoListEntity {
            /**
             * brandId : 12
             * brandName : Supreme
             * brandLittleLogo : http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86%E5%93%81%E7%89%8C@2x.png
             * brandLargeLogo : http://p198v6g26.bkt.clouddn.com/%E9%A6%96%E9%A1%B5%E5%93%81%E7%89%8C@2x.png
             * brandDesc : Supreme1994年秋季诞生于美国纽约曼哈顿，由James Jebbia创办。supreme的本意是最高、至上的。Supreme是结合滑板、Hip-hop等文化并以滑板为主的美国街头服饰品牌。
             * brandListImg : http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E9%A6%86@2x.png
             * brandDetailImg : http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E5%9B%BE@2x.png
             * brandDetailLogo : http://p198v6g26.bkt.clouddn.com/%E5%93%81%E7%89%8C%E8%AF%A6%E6%83%85%E5%93%81%E7%89%8C@2x.png
             */

            private int brandId;
            private String brandName;
            private String brandLittleLogo;
            private String brandLargeLogo;
            private String brandDesc;
            private String brandListImg;
            private String brandDetailImg;
            private String brandDetailLogo;

            public int getBrandId() {
                return brandId;
            }

            public void setBrandId(int brandId) {
                this.brandId = brandId;
            }

            public String getBrandName() {
                return brandName;
            }

            public void setBrandName(String brandName) {
                this.brandName = brandName;
            }

            public String getBrandLittleLogo() {
                return brandLittleLogo;
            }

            public void setBrandLittleLogo(String brandLittleLogo) {
                this.brandLittleLogo = brandLittleLogo;
            }

            public String getBrandLargeLogo() {
                return brandLargeLogo;
            }

            public void setBrandLargeLogo(String brandLargeLogo) {
                this.brandLargeLogo = brandLargeLogo;
            }

            public String getBrandDesc() {
                return brandDesc;
            }

            public void setBrandDesc(String brandDesc) {
                this.brandDesc = brandDesc;
            }

            public String getBrandListImg() {
                return brandListImg;
            }

            public void setBrandListImg(String brandListImg) {
                this.brandListImg = brandListImg;
            }

            public String getBrandDetailImg() {
                return brandDetailImg;
            }

            public void setBrandDetailImg(String brandDetailImg) {
                this.brandDetailImg = brandDetailImg;
            }

            public String getBrandDetailLogo() {
                return brandDetailLogo;
            }

            public void setBrandDetailLogo(String brandDetailLogo) {
                this.brandDetailLogo = brandDetailLogo;
            }
        }
    }
}
