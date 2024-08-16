<template>
  <WelcomeItem>
    <template #icon>
      <DocumentationIcon />
    </template>
    <template #heading>四柱八字</template>

    四柱即出生人的出生年、月、日、时分别称之为年柱、月柱、日柱和时柱；以天干地支纪年法表示出来每柱两个字，共八个字也称生辰八字，用以推算个人运程。
    <!-- <a href="https://vuejs.org/" target="_blank" rel="noopener">official documentation</a> -->
  </WelcomeItem>

  <WelcomeItem>
    <template #icon>
      <ToolingIcon />
    </template>
    <template #heading
      >十神 - <a href="#" rel="noopener">{{ tenGodName }}</a></template
    >
    <div v-html="tenGod"></div>
  </WelcomeItem>

  <WelcomeItem>
    <template #icon>
      <EcosystemIcon />
    </template>
    <template #heading
      >神煞 - <a href="#" rel="noopener">{{ shenShaName }}</a></template
    >
    <div v-html="shenSha"></div>
  </WelcomeItem>

  <WelcomeItem>
    <template #icon>
      <CommunityIcon />
    </template>
    <template #heading
      >格局 - <a href="#" rel="noopener">{{ patternName }}</a></template
    >
    <div v-html="pattern"></div>
  </WelcomeItem>

  <WelcomeItem>
    <template #icon>
      <SupportIcon />
    </template>
    <template #heading>Lunar</template>

    本项目使用Lunar-java来作为快速读取八字信息的快捷工具，详情请移步原作者
    <a href="https://gitee.com/6tail/lunar-java" target="_blank" rel="noopener">Gitee仓库地址</a>
  </WelcomeItem>
</template>

<script setup lang="ts">
import WelcomeItem from './WelcomeItem.vue'
import DocumentationIcon from './icons/IconDocumentation.vue'
import ToolingIcon from './icons/IconTooling.vue'
import EcosystemIcon from './icons/IconEcosystem.vue'
import CommunityIcon from './icons/IconCommunity.vue'
import SupportIcon from './icons/IconSupport.vue'
import { onMounted, ref } from 'vue'

let tenGod: any = ref('')
let tenGodName: any = ref('')
let shenSha: any = ref('')
let shenShaName: any = ref('')
let pattern: any = ref('')
let patternName: any = ref('')

/**
 * 获取格局名称
 * @param num 随机数
 */
const getPatternName = (num: number) => {
  switch (num) {
    case 0:
      return '三奇贵人格'
    case 1:
      return '禄元互换格'
    case 2:
      return '天元一气格'
    case 3:
      return '杀印相生格'
    case 4:
      return '食神制杀格'
    case 5:
      return '身杀两停格'
    case 6:
      return '伤官配印格'
    case 7:
      return '伤官生财格'
    case 8:
      return '伤官泄秀格'
    case 9:
      return '枭神夺食格'
  }
}

/**
 * 获取格局信息
 * @param num 随机数
 */
const getPatternMessage = (num: number) => {
  switch (num) {
    case 0:
      return '三奇贵人是指天奇、地奇、人奇<br/>命带三奇者，总是博学多才，一生抱负极大，胸襟宽阔，有功名，有成就，是大富大贵之人<br/>乙丙丁为天上三奇，甲戊庚为地上三奇，辛壬癸为人间三奇，四柱中这三类天干同时出现叫做三奇贵人格'
    case 1:
      return '禄元互换格中年成大事儿，大富大贵的格局<br/>以日柱为依据：  戊申日见乙卯时；丁酉日见壬寅时；丙子日见癸巳时；庚子日见丁亥时<br/>以丙子癸巳为例，癸克丙为丙之正官，癸克丙为癸之正财，所以是大富大贵'
    case 2:
      return '年柱 月柱 日柱 时柱这四柱都是一样的，命运较为奇特<br/>古书讲，人之八字，最宜四柱流通，五行生化；大忌四柱缺陷，五行偏枯。虽然富足但孤傲而且寿短<br/>除了天干一气，还要地支一气格'
    case 3:
      return '杀生印，印生身，富贵双全。杀不离印，印不离杀，杀印相生，功名显达<br/>克制七杀的方法有两个，身弱印枭来化杀。身强食伤来克制杀<br/>七杀本为偏官，但因性质凶狠，索人性命，古人用杀来命名'
    case 4:
      return '食神制杀格，是指一个人本身身强，此时印为忌凶，命中七杀太旺，可以使用食神伤官压制七杀，不过伤官有狂傲之气，伤官制杀容易惹出是非<br/>日元弱，七杀多，需要印枭来化杀，把七杀为己所用，叫做杀印相生；日元强，七杀多，需要食伤来解，叫做食神制杀'
    case 5:
      return '入格者富贵双全，风云翘楚，大富大贵<br/>一个八字日元和七杀能量差不多，日元时刻处于一个均衡状态，大运流年遇到财星，日元去克财，就比较容易发财<br/>格局要求本命局不要有刑冲破害，否则贵气减少'
    case 6:
      return '坏的一面：狂妄自大，不服管教，一身傲骨，自视不凡，恃才傲物，锋芒毕露<br/>好的一面：积极开拓，上进心强，争强好胜，聪明伶俐，越挫越勇，多才多艺<br/>日元身弱，伤官为忌凶，印为喜用，以印制伤，才能成格'
    case 7:
      return '聪明不过伤官，伶俐不过七杀。伤官代表聪明，代表上进心，不服输的精神，八字日元身强，伤官旺，财旺，必是富贵之人。伤官配印主贵，伤官生财主富。<br/>日元身强，伤官为喜用，财才为喜用，以伤生财才，卸掉伤官恶神之气，方能成格'
    case 8:
      return '日元身强的情况下，全盘只有比劫印枭和伤官，伤官得用，可以把自身的能力发挥出来，也是贵格之一。必为聪明绝顶之人，才华横溢，多为艺术表演和文人学术之人。<br/>伤管泄秀格与伤管配印格的成格条件基本相同，唯一不同的是一个身强一个身弱'
    case 9:
      return '偏印称为枭神，八字中如果没有食神，偏印以正印算，代表保护日元的能量，另外代表心思细腻，善于分析，第六感强，适合神职工作，多愁善感，抑郁不开心等信息。如果八字中又出现了食神，偏印称为枭神，专门跟消耗食神。食神为福气，财根，一般原命局出现枭神夺食。命主走到食神，必然出现不开心的事情'
  }
}

/**
 * 获取神煞名称
 * @param num 随机数
 */
const getShenShaName = (num: number) => {
  switch (num) {
    case 0:
      return '天德贵人'
    case 1:
      return '月德贵人'
    case 2:
      return '天乙贵人'
    case 3:
      return '文昌贵人'
    case 4:
      return '驿马'
    case 5:
      return '太极贵人'
    case 6:
      return '华盖'
    case 7:
      return '劫煞'
    case 8:
      return '灾煞'
    case 9:
      return '血刃'
  }
}
/**
 * 获取神煞信息
 * @param num 随机数
 */
const getShenShaMessage = (num: number) => {
  switch (num) {
    case 0:
      return '护身神煞，命带这两个神煞可得天佑神助，遇难呈祥，化险为夷'
    case 1:
      return '同天德贵人，凡八字中有天月二德，其人慈祥心善，待人至诚仁厚'
    case 2:
      return '命中最吉之神煞，解难神煞，贵人相助之神煞，遇到困难有人帮助，做事容易成功'
    case 3:
      return '利读书，考试，学习的神煞，气质雅秀，举止温文，好学新知，具上进心，男命逢文昌有内涵，女命逢文昌仪容优雅'
    case 4:
      return '奔波，出门，车辆信息之神煞'
    case 5:
      return '主人聪明好学，文采飞扬，好奇心重，喜神秘事物，如周易命理，中医气功、特异功能'
    case 6:
      return '半吉半凶之神煞，孤独之星，艺术星，与佛道有缘，有皈依的念头，山，医，命，相，卜必有一技之长，神煞带有华盖之人偏爱干净整洁，更甚至还有洁癖'
    case 7:
      return '劫煞为凶神，一般而言主是非，破财，并主病伤刑法之灾。若日元强旺，又带劫煞，可以从事武职'
    case 8:
      return '命中逢灾煞，经常恶运缠身，主疾病，官司，牢狱之灾、破财等种种不吉之兆，四柱无天乙，天德月德，护身之神会发生坏事'
    case 9:
      return '血刃与身体受到伤害有关；主血光之灾，八字中带血刃神煞者特别容易遇到意外、开刀、住院等流血事件'
  }
}
/**
 * 获取十神信息
 * @param num 随机数
 */
const getTenGodMessage = (num: number) => {
  switch (num) {
    case 0:
      return '生我者为印枭，阳生阴我，阴生阳我，为正印<br/>性格：聪明智慧，记性好，喜欢学习，心地善良，责任心强，少病少灾<br/>日元身弱，最喜正印来生；日元身强，正印来生反为害'
    case 1:
      return '我生者为食伤，阳我生阳，阴我生阴，为食神<br/>性格：口才好，喜欢玩，好歌舞酒色，吃货，多福多寿，心宽体胖，为人宽宏大量，对艺术天赋异禀<br/>日元身强，食神为喜用时能够泄化日主和比劫;日元身弱，再去生食神，食神为凶，代表自己腹有诗书，难遇伯乐'
    case 2:
      return '克我者为官杀，阳克阴我，或阴克阳我，为正官<br/>性格：守信用、正直、光明磊落、好面子，在乎名声地位、廉洁、公正、稳重<br>女命正官代表老公'
    case 3:
      return '我克者为财才，阳我克阴，阴我克阳，为正财<br/>性格：守本分，诚实可靠，脚踏实地，勤俭节约，重视家庭，诚信，值得信赖<br>财喜藏不喜漏。天干之财为虚财，地支藏干里的财为真财'
    case 4:
      return '克我者为官杀，阴阴相克，阳阳相克，称之为（七杀）偏官<br/>性格：执行力强，有正义感和侠义精神，做事有魄力;霸道，急躁如火，脾气古怪，任性倔强，好胜好斗，报复心强<br/>聪明不过伤官，伶俐不过七杀'
    case 5:
      return '生我者为印枭，阳生阳我，阴生阴我，为偏印，古人称之为枭神<br/>性格：敏锐的观察力，分析力，感受力，理解力，内心孤独，优柔寡断，犹豫不决<br/>其他干支偏印，命主会学习技术技能。月令偏印，必定有一技之长'
    case 6:
      return '我生者为食伤，阳我生阴，阴我生阳，为伤官<br/>性格：聪明灵巧，个性突出，容易抢风头，能言善辩，言语尖锐刻薄，狂傲不羁，逞强好胜，一身傲骨<br/>伤官配印，非富即贵;本命有伤官，大运流年遇到伤官，易有官司口舌纷争'
    case 7:
      return '同我者为比劫，阳同阴，阴同阳，为劫财；劫财在地支又名羊刃<br/>性格：性格开朗，心思敏捷，个性明显，自尊心强，固执己见，自我矛盾，贪小便宜<br/>男命带劫财，大运流年又有劫财，会跟妻子分开，并具投资容易破财'
    case 8:
      return '同我者为比劫，阳同阳，阴同阴，为比肩<br/>性格：意志坚强，重情重义，独立自主，独断专行，自我中心，朋友很多，但知己不多<br/>比肩为用神，多得朋友或兄弟帮助；比肩为忌神，得不到朋友或兄弟的帮助，反而被争夺财物'
    case 9:
      return '我克者为财才，阳我克阳，阴我克阴，为偏财<br/>性格：慷慨大方，重义轻财，聪明机巧，不善理财，一心多用，轻浮放荡<br/>偏财为人大方慷慨，会去帮助朋友，所以对方愿意提供消息，让自己获得回报，偏财比正财'
  }
}
/**
 * 获取十神名称
 * @param num 随机数
 */
const getTenGodName = (num: number) => {
  switch (num) {
    case 0:
      return '正印'
    case 1:
      return '食神'
    case 2:
      return '正官'
    case 3:
      return '正财'
    case 4:
      return '七杀'
    case 5:
      return '偏印'
    case 6:
      return '伤官'
    case 7:
      return '劫财'
    case 8:
      return '比肩'
    case 9:
      return '偏财'
  }
}

onMounted(() => {
  let randomNumber = Math.floor(Math.random() * 10)
  tenGod.value = getTenGodMessage(randomNumber)
  tenGodName.value = getTenGodName(randomNumber)
  shenSha.value = getShenShaMessage(randomNumber)
  shenShaName.value = getShenShaName(randomNumber)
  pattern.value = getPatternMessage(randomNumber)
  patternName.value = getPatternName(randomNumber)
})
</script>
