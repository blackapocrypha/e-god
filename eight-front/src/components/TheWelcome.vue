<template>
  <div class="welcome-grid">
    <WelcomeItem>
      <template #icon>
        <DocumentationIcon />
      </template>
      <template #heading>四柱八字</template>
      <p>
        四柱即出生人的年、月、日、时，分别称年柱、月柱、日柱、时柱；以天干地支纪年法每柱两字，共八字（生辰八字），用以推算运程。
      </p>
    </WelcomeItem>

    <WelcomeItem>
      <template #icon>
        <ToolingIcon />
      </template>
      <template #heading>
        十神 · <span class="hl">{{ tenGodName }}</span>
      </template>
      <div v-html="tenGod"></div>
    </WelcomeItem>

    <WelcomeItem>
      <template #icon>
        <EcosystemIcon />
      </template>
      <template #heading>
        神煞 · <span class="hl">{{ shenShaName }}</span>
      </template>
      <div v-html="shenSha"></div>
    </WelcomeItem>

    <WelcomeItem>
      <template #icon>
        <CommunityIcon />
      </template>
      <template #heading>
        格局 · <span class="hl">{{ patternName }}</span>
      </template>
      <div v-html="pattern"></div>
    </WelcomeItem>

    <WelcomeItem>
      <template #icon>
        <SupportIcon />
      </template>
      <template #heading>Lunar</template>
      <p>
        采用 Lunar-java 读取八字信息，
        <a href="https://gitee.com/6tail/lunar-java" target="_blank" rel="noopener">详情见 Gitee</a>
      </p>
    </WelcomeItem>
  </div>
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

const getPatternName = (num: number) => {
  const names = ['三奇贵人格', '禄元互换格', '天元一气格', '杀印相生格', '食神制杀格', '身杀两停格', '伤官配印格', '伤官生财格', '伤官泄秀格', '枭神夺食格']
  return names[num]
}

const getPatternMessage = (num: number) => {
  const msgs = [
    '三奇贵人：天奇、地奇、人奇。命带三奇者博学多才，一生抱负极大，胸襟宽阔，大富大贵。<br/>乙丙丁天上三奇，甲戊庚地上三奇，辛壬癸人间三奇。',
    '禄元互换格主大富大贵。戊申日见乙卯时，丁酉日见壬寅时，丙子日见癸巳时，庚子日见丁亥时。癸克丙为正官亦为癸之正财。',
    '年柱月柱日柱时柱四柱全同，命运奇特。古书云：八字最宜四柱流通、五行生化；大忌四柱缺陷、五行偏枯。虽富而孤寿短。',
    '杀生印，印生身，富贵双全。杀不离印，印不离杀，杀印相生，功名显达。身弱印化杀，身强食制杀。',
    '身强命中七杀旺，食神伤官压制七杀。日元弱七杀多需印来化杀为杀印相生；日元强七杀多需食伤来解为食神制杀。',
    '入格者富贵双全，风云翘楚。日元与七杀能量相当，大运流年遇财星易发财。要求命局无刑冲破害。',
    '狂妄自大不服管教，一身傲骨自视不凡。但积极开拓上进心强，聪明伶俐越挫越勇。日元身弱伤官为忌，以印制伤成格。',
    '聪明不过伤官，伶俐不过七杀。日元身强伤官旺财旺必是富贵人。伤官配印主贵，伤官生财主富。',
    '日元身强全盘比劫印枭和伤官，伤官得用脱颖而出。聪明绝顶才华横溢，多为艺术表演文人学术之人。',
    '偏印为枭神，无食神时以正印论护身。八字又有食神则枭神夺食。食神为福气财根，命主走食神必遇不开心之事。'
  ]
  return msgs[num]
}

const getShenShaName = (num: number) => {
  const names = ['天德贵人', '月德贵人', '天乙贵人', '文昌贵人', '驿马', '太极贵人', '华盖', '劫煞', '灾煞', '血刃']
  return names[num]
}

const getShenShaMessage = (num: number) => {
  const msgs = [
    '护身神煞，得天佑神助，遇难呈祥，化险为夷。',
    '同天德贵人，八字中有天月二德者慈祥心善，待人诚仁厚。',
    '命中最吉之神煞，解难贵人相助。遇困难有人帮，做事易成功。',
    '利读书考试学习。气质雅秀，举止温文，好学新知，上进心强。男命有内涵，女命仪容优雅。',
    '奔波、出门、车辆信息之神煞。',
    '聪明好学，文采飞扬，好奇心重，喜神秘事物如周易命理中医气功。',
    '半吉半凶。孤独之星、艺术星，与佛道有缘。山医命相卜必有一技之长，偏爱整洁。',
    '凶神，主是非破财病伤刑法之灾。日元强旺又带劫煞可从事武职。',
    '恶运缠身，主疾病官司牢狱破财。无天乙天德月德护身易有坏事。',
    '与身体伤害有关。主血光之灾，特别容易遇到意外、开刀、住院等流血事件。'
  ]
  return msgs[num]
}

const getTenGodMessage = (num: number) => {
  const msgs = [
    '生我者为印枭，阳生阴我、阴生阳我为正印。<br/>聪明智慧记性好，心地善良责任心强。日元身弱最喜正印生；日元身强正印反为害。',
    '我生者为食伤，阳我生阳、阴我生阴为食神。<br/>口才好，多福多寿心宽体胖，对艺术天赋异禀。身强泄化比劫；身弱难遇伯乐。',
    '克我者为官杀，阳克阴我、阴克阳我为正官。<br/>守信用正直光明磊落，在乎名声地位。女命正官代表丈夫。',
    '我克者为财才，阳我克阴、阴我克阳为正财。<br/>守本分诚实可靠，勤俭节约重视家庭。财喜藏不喜漏，地支藏干之财为真财。',
    '克我者为官杀，阴克阴、阳克阳为七杀（偏官）。<br/>执行力强有侠义精神，做事有魄力；但急躁霸道，好胜好斗报复心强。',
    '生我者为印枭，阳生阳我、阴生阴我为偏印（枭神）。<br/>敏锐观察分析理解力，内心孤独优柔寡断。月令偏印必有一技之长。',
    '我生者为食伤，阳我生阴、阴我生阳为伤官。<br/>聪明灵巧个性突出，狂傲不羁一身傲骨。伤官配印非富即贵。',
    '同我者为比劫，阳同阴、阴同阳为劫财；地支又名羊刃。<br/>性格开朗心思敏捷，自尊心强固执己见。男命带劫财大运流年又遇劫财易破财。',
    '同我者为比劫，阳同阳、阴同阴为比肩。<br/>意志坚强重情重义独立自主。比肩为用多得朋友帮助；为忌反被争夺。',
    '我克者为财才，阳我克阳、阴我克阴为偏财。<br/>慷慨大方面，聪明机巧，不善理财一心多用。偏财比正财更慷慨。'
  ]
  return msgs[num]
}

const getTenGodName = (num: number) => {
  const names = ['正印', '食神', '正官', '正财', '七杀', '偏印', '伤官', '劫财', '比肩', '偏财']
  return names[num]
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

<style scoped>
.welcome-grid {
  display: grid;
  gap: var(--space-md);
}

.hl {
  color: var(--color-primary);
  font-family: var(--font-serif);
}

@media (min-width: 1024px) {
  .welcome-grid {
    grid-template-columns: 1fr;
  }
}
</style>
