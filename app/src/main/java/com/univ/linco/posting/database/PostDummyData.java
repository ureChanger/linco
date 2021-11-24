package com.univ.linco.posting.database;

import com.univ.linco.R;
import com.univ.linco.thumbnail.ThumbnailItem;

import java.util.ArrayList;
import java.util.Arrays;

public class PostDummyData {
    private ArrayList<Post> postDummyData = new ArrayList<Post>(
            Arrays.asList(
                    new Post(
                            "dummy",
                            "camping",
                            "캠핑 버터플라이 체어",
                            "고급 너도밤나무 원목 사용,고급스런 캔버스원단 사용 고급스러운 " +
                                    "디자인으로 더욱 멋스러운 감성을 느낄 수 있습니다.",
                            50,
                            50,
                            "https://cafe.naver.com/campingboy/180",
                            "2020-10-05",
                            Integer.toString(R.drawable.drawable_post_1),
                            "naver"
                    ),
                    new Post(
                            "dummy",
                            "baby",
                            "공룡식기 식판세트",
                            "밀에서 추출한 안전한 소재로 만든\n" +
                                    "캐릭터 친환경 유아식기 소개해드려용\n" +
                                    "\n" +
                                    "아이들이 좋아하는 감성적이고 귀여운\n" +
                                    "공룡모양의 귀여운 식판 세트에요",
                            100,
                            92,
                            "https://www.instagram.com/p/CWmdMPhPP3k/",
                            "2021-11-23",
                            Integer.toString(R.drawable.drawable_post_6),
                            "instagram"
                    ),
                    new Post(
                            "dummy",
                            "fashion",
                            "폴로 랄프로렌 니트 브이넥 라운드",
                            "크림, 블랙, 그레이, 네이비 총 4컬러 라운드넥, 브이넥이 있습니다." +
                                    "11월 20일(토)부터 시작되며 주문 폭주시 예고없이 품절될 수 있습니다.",
                            100,
                            32,
                            "https://blog.naver.com/kyozkyoz/222573540524",
                            "2021-11-20",
                            Integer.toString(R.drawable.drawable_post_2),
                            "naver"
                    ),
                    new Post(
                            "dummy",
                            "beauty",
                            "프레미오21 I&E솔루션 전해질 미스트 피부링겔미스트",
                            "원래 피부 세포가 가지고 있는 자연스런 주기와 매커니즘으로 최상의 효과를 보이며" +
                                    "SKIN CARE 개념을 넘어 SKIN CURE의 개념으로 다가가고자 합니다.",
                            990,
                            532,
                            "https://blog.naver.com/hahhaya/222255590073",
                            "2021-02-25",
                            Integer.toString(R.drawable.drawable_post_3),
                            "naver"
                    ),
                    new Post(
                            "dummy",
                            "health",
                            "프리미엄 콜라겐, 퍼펙트큐브플러스",
                            "겨울철에는 매일이 건조합과의 전쟁인데요. 최근 알게된 사실, 건조한 사람이" +
                                    "정전기가 더 많이 생긴대요. 이대로는 안되겠다 싶어서 계절 바뀌면서 더 열심히" +
                                    "콜라겐 챙기고 있어요. 후회없는 결정이시니 연락주세요!",
                            30,
                            2,
                            "https://blog.naver.com/hyunjin_seo/222563213012",
                            "2021-11-09",
                            Integer.toString(R.drawable.drawable_post_4),
                            "naver"
                    ),
                    new Post(
                            "dummy",
                            "health",
                            "람노서스에이스 유산균",
                            "캐나다 직수입 람노서스에이스 유산균 공동구매입니다." +
                                    "너무나 좋은 원료로 잘 만들어진 제품이기 때문에 이렇게 긴 시간 함께 " +
                                    "하는 것 같아요. 공동구매는 상시 진행중이에요!",
                            1000,
                            589,
                            "https://blog.naver.com/thedining1207/222547390588",
                            "2021-10-25",
                            Integer.toString(R.drawable.drawable_post_5),
                            "naver"
                    ),
                    new Post(
                            "dummy",
                            "baby",
                            "크리스마스 망토 원피스",
                            "\uD83D\uDCE211월24일 공구마감\n" +
                                    "울 딸랑구들 크리스마스에\n" +
                                    "이쁘게 입힐 망토 원피스 소개드려요\uD83C\uDF84\uD83C\uDF84\n" +
                                    "\n" +
                                    "커다란 모자가 달린 망토 원피스랍니다❤\n" +
                                    "클스마스룩은 요걸로 끝!!\uD83C\uDF3C\n" +
                                    "너무 귀여워용 아이들 반응도 넘 좋답니다",
                            42,
                            25,
                            "https://www.instagram.com/p/CWlCXBXPkZV/",
                            "2021-11-22",
                            Integer.toString(R.drawable.drawable_post_7),
                            "instagram"
                    ),
                    new Post(
                            "dummy",
                            "baby",
                            "유아 멀티책상 2종",
                            "✔친환경등급 SE0유럽산 자작나무합판100%\n" +
                                    "✔그린가드인증 HPM(라미네이트코팅)컬러마감\n" +
                                    "✔절단면 아우로 천연오일마감\n" +
                                    "✔책상단품에 멀티거치대 옵션으로 선택가능 합니다.",
                            100,
                            37,
                            "https://www.instagram.com/p/CWnBS0MPwPk/",
                            "2021-11-23",
                            Integer.toString(R.drawable.drawable_post_8),
                            "instagram"
                    )
            )
    );

    public ArrayList<Post> getPostDummyData(){
        return postDummyData;
    }
}
