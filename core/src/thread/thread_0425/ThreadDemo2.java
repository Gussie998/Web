package thread.thread_0425;

/**
 * User:DELL
 * Date:2021-04-25
 * Time:19:10
 */
public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
        String content = "阳光明媚的春日，山里的小熊仔迷了路，来到了人类繁华的大都市。\n" +
                "\n" +
                "这里有数不清的道路，看不完的楼房，到处都是复杂的、陌生的，小熊仔在城里转了一圈又一圈，又饿又渴，又累又热，完全不知道该怎么办，急得哭了起来。\n" +
                "\n" +
                "好在城里的居民都很善良，看见一只迷路的小熊仔趴在小公园的喷泉旁哭，大家决定帮助它。\n" +
                "\n" +
                "戴假牙的老奶奶把自己坐着的长椅与软垫让了出来，让小熊仔可以坐下来好好休息。\n" +
                "\n" +
                "戴眼镜的温柔姐姐把自己的午餐便当分给小熊吃，止住了小熊仔的肚皮再咕咕叫唤。\n" +
                "\n" +
                "骑单车的开朗少年给小熊仔买来了多加冰的大杯奶茶，降温又解渴，而且特别好喝。\n" +
                "\n" +
                "还有个嘟嘟脸的小姑娘，她蹲在小熊仔面前认真看了看，说小熊仔你看起来好像不是很开心，这样吧，我送给你一个最开心的笑脸。\n" +
                "\n" +
                "然后她就咧嘴笑起来，露出嘴巴里正在换牙的黑洞洞，非常可爱。\n" +
                "\n" +
                "这些好心的礼物果然让小熊仔重新快活起来，它现在又是一只会在飘着花瓣的樱花树下蹦蹦跳跳的元气小熊仔了。\n" +
                "\n" +
                "它非常感谢城里的热心人们。\n" +
                "\n" +
                "同时它也有点不好意思，自己怎么可以只接受帮助，不回报别人呢。\n" +
                "\n" +
                "嗯，这只小熊仔其实也是一只很骄傲的小熊仔，除了被照顾被关爱，它也会希望自己能有用处，被别人真心实意地需要。\n" +
                "\n" +
                "可是，它又能回报大家什么呢？\n" +
                "\n" +
                "毕竟，它只是一只迷了路的森林小熊仔啊。\n" +
                "\n" +
                "还是聪明的小姑娘替它出主意：没关系，你有什么就可以送什么，总有人需要的。你看我有笑脸就送人笑脸，你想想自己有什么呢？\n" +
                "\n" +
                "小熊仔开始憋着气努力想。\n" +
                "\n" +
                "想啊想，想啊想，想到它的胖脸蛋都憋得通红了，终于想到了。\n" +
                "\n" +
                "长得敦敦实实的小熊仔，有数不清的拥抱可以送给别人啊！\n" +
                "\n" +
                "小熊仔有些心虚地问小姑娘，城里的人们什么都有，他们会需要我的熊抱吗？\n" +
                "\n" +
                "小姑娘说当然啦，大家正好很缺这个呢！走，我们现在就去送抱抱！\n" +
                "\n" +
                "于是在和煦阳光的照耀下，小姑娘领着小熊仔从城东走到城西，再从城南走到城北，一路上发现了好多需要这个拥抱的人。\n" +
                "\n" +
                "比如先前那位戴眼镜的温柔姐姐，正在为了工作上的难题而发愁，小熊仔走过去，给她一个安心的抱抱，告诉她别太着急呀，你已经做得很好了。\n" +
                "\n" +
                "比如先前那个骑单车的开朗少年，刚巧被暗恋的女孩拒绝了，看起来很失落，小熊仔也给他一个理解的抱抱，说没关系，有我们陪着你，你想要表达难过，或者想说别的什么都可以。\n" +
                "\n" +
                "再比如先前那位戴假牙的老奶奶，她正在思念自己在远方工作的孩子，小熊仔特别贴心地拥抱她，说奶奶有我这样抱着你，你会不会觉得心里的孤单少一点？\n" +
                "\n" +
                "老奶奶很高兴，笑得脸上的皱纹都舒展开来。\n" +
                "\n" +
                "她摸摸小熊仔的头，夸它是个好孩子，带给大家很多安慰和好心情。\n" +
                "\n" +
                "得了表扬的小熊仔更有干劲了，干脆和小姑娘一起回到最初的公园，在花瓣飞舞的樱花树下摆了个小摊，打出“春日抱抱熊”的招牌，专门出售它的抱抱。\n" +
                "\n" +
                "无论是失意想要安慰的人，无聊想找乐子的人，自卑想要鼓励的人，还是快乐想要分享的人，都可以来这里买一个货真价实的熊抱。\n" +
                "\n" +
                "这个抱抱会很亲切，很温和，而且还可以买一送一，附赠客人撸一把小熊仔身上柔软的毛毛呢。\n" +
                "\n" +
                "至于价格也非常公道，小熊仔只需要一句真诚的“谢谢”就够啦。\n" +
                "\n" +
                "结果这个小摊的生意非常火爆，“春日抱抱熊”的名声传遍了整个城市，来排队的人一眼都望不到头。\n" +
                "\n" +
                "这把小熊仔给忙坏了，不停地送出抱抱，直到夕阳西下，大家都回家吃晚餐了，人群才逐渐散去，小熊仔也终于可以收摊了。\n" +
                "\n" +
                "当然，这一天的经历让它自己也很高兴，感觉自己做了些对大家很有用的好事情呢。\n" +
                "\n" +
                "就是肚子又饿了。小熊仔拍了拍自己圆滚滚的肚皮，听着它开始大声叫唤，不禁有些难为情。\n" +
                "\n" +
                "一直陪着它摆摊的小姑娘主动请它回自己家吃晚餐。\n" +
                "\n" +
                "不过在那之前，她也想要一个抱抱。\n" +
                "\n" +
                "嗯？小熊仔有点不理解，说你看起来没有什么烦恼啊，为什么想要一个抱抱？\n" +
                "\n" +
                "小姑娘磨磨蹭蹭地拿出一张考试卷子，至于上面的分数嘛……不提也罢。\n" +
                "\n" +
                "她讪讪地表示，自己不过是偶然失手，只是还是忍不住有那么一丢丢的小介意，所以她想要一个爱的抱抱，当然没有也行，她并不是那么经不起打击的人，事实上她很有觉悟，一直觉得在考试的江湖上闯荡，总是得面对些大起大落，自己对此早就有心理准备，完全不会为此有什么……\n" +
                "\n" +
                "她还没来得及说完，小熊仔便用一个热烈的熊抱打断了她：“那下次加油吧！”\n" +
                "\n" +
                "小姑娘愣了一下。\n" +
                "\n" +
                "啊，怪不得大家都那么喜欢抱抱，真的很温暖，很有爱啊。\n" +
                "\n" +
                "于是小姑娘也抱住了小熊仔，笑着说好。";
        for (char item :content.toCharArray()
             ) {
            System.out.print(item);
            Thread.sleep(250);
        }
    }




}
